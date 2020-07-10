using System;

using System.Text.RegularExpressions;

using System.Net;

using System.IO;
using System.Linq;

namespace CPPconferences
{
    class Program
    {
        private static readonly string titles = @"C:\Users\robyb\OneDrive\Desktop\CPPconferences\conferences seen.txt";
        private static readonly string urlIn = @"C:\Users\robyb\OneDrive\Desktop\CPPconferences\urlIn.txt";
        private static readonly string urlOut = @"C:\Users\robyb\OneDrive\Desktop\CPPconferences\urlOut.txt";
        private static string url;

        private static string PickURL()
        {
            switch (File.ReadAllBytes(urlIn).Length)
            {
                case 0:
                    Console.WriteLine("url file is empty."); Console.ReadKey();
                    return "";
                default:
                    {
                        url = File.ReadLines(urlIn).First();
                        File.WriteAllLines(urlIn, File.ReadAllLines(urlIn).Skip(1));
                        WebClient x = new WebClient();
                        return x.DownloadString(url);
                    }
            }
        }

        private static string GetTitle()
        {
            string html = PickURL();
            return html != ""
                ? Regex.Match(html, @"\<title\b[^>]*\>\s*(?<Title>[\s\S]*?)\</title\>",
                RegexOptions.IgnoreCase).Groups["Title"].Value
                : html;
        }

        private static bool IsValid(string title)
        {
            string[] fileText = File.ReadAllLines(titles);
            return !fileText.Contains(title);
        }

        private static string RepairTitle(string temp)
        {
            temp = temp.Replace("â€œ", "''");
            temp = temp.Replace("â€", "''");
            temp = temp.Replace("&quot", "''");
            temp = temp.Replace("ï¼œï¼ž", "<>");
            temp = temp.Replace("&amp:", "&");
            temp = temp.Replace("&#39;", "'");
            return temp;
        }

        private static void OpenURL()
        {
            string title = GetTitle();
            title = RepairTitle(title);
            if (IsValid(title)
                && title != "")
            {
                System.Diagnostics.Process.Start(url);
                System.Diagnostics.Process.Start("https://www.youtube.com/");
                File.AppendAllText(titles, title + Environment.NewLine);
                File.AppendAllText(urlOut, url + Environment.NewLine);
            }
            else
            {
                Console.WriteLine("You've seen this video before");
                if (title != "")
                    OpenURL();
            }
        }

        private static void Main(string[] args)
        {
            System.Diagnostics.Process.Start(urlIn);
            OpenURL();
        }
    }
}
