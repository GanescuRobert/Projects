#include <iostream>
#include <graphics.h>

extern char word[11][15];
extern int flags[20][20];
extern int a[20][20];

void lose(){
    int x,y;
    for(int i=1;i<=10;i++)
        for(int j=1;j<=10;j++){
            y=i*50;x=j*50;
            if(flags[i][j]==a[i][j]-10)
                readimagefile("10.jpg",x,y,x+50,y+50);
            else
                readimagefile(word[a[y/50][x/50]],x,y,x+50,y+50);
        }
}
