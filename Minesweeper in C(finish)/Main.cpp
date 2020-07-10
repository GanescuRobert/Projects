#include <graphics.h>
#include <iostream>
#include <windows.h>
#include <ctime>

#define VK_R 0x52

    void CitirePoze();
    void Matrice();
    void lose();
    int check0(int x,int y);

    extern int a[20][20];
    extern char word[11][15];
    extern int matriceFill[20][20];


    int n=10,b=10;
    int flags[20][20];
    bool DEFEAT,RESTART;
    bool GAME=1,RESTART_GAME=1,Ai_Castigat=1;

using namespace std;

void round(int &x,int &y,int nr){

    while(x%nr!=0)
        x--;
    while(y%nr!=0)
        y--;
}

int main(){

    CitirePoze();

    initwindow(700,700,"",-3,-3);

    settextstyle(0,HORIZ_DIR,4);

    POINT currentPosition;
    int x,y;
    int bomba=0;

    while(GAME){

        memset(a,0,sizeof(a));
        memset(matriceFill,0,sizeof(matriceFill));
        memset(flags,0,sizeof(flags));

        Matrice();
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++){
                int y=i*50,x=j*50;
                readimagefile("button.jpg",x,y,x+50,y+50);
            }
        readimagefile("Restart.jpg",625,625,675,675);

        DEFEAT=0;
        RESTART=0;

        while(RESTART_GAME){

/********************* restart lose play ******************/

           if(GetAsyncKeyState(VK_LBUTTON)||RESTART){
                GetCursorPos(&currentPosition);
                x=currentPosition.x;
                y=currentPosition.y;
                round(x,y,25);
                if((x>624&&x<676&&y>624&&y<676)||GAME==0){
                    break;
                }
           }
            while(DEFEAT==0){

                GetCursorPos(&currentPosition);
                x=currentPosition.x;
                y=currentPosition.y;

/********************* restart play ******************/

                if(GetAsyncKeyState(VK_LBUTTON)){
                    round(x,y,25);
                    if(x>624&&x<676&&y>624&&y<676){
                        RESTART=1;
                        break;
                    }
                }

/*********************without contur ******************/

                if(x>51&&x<549&&y>51&&y<549){

/********************* click L ******************/

                    if(GetAsyncKeyState(VK_LBUTTON)){
                        delay(80);
                        round(x,y,50);
                        if(flags[y/50][x/50]==0&&matriceFill[y/50][x/50]!=-1){
                            if(a[y/50][x/50]==0){
                                check0(y/50,x/50);
                                for(int i=1;i<=10;i++)
                                    for(int j=1;j<=10;j++){
                                        if(matriceFill[i][j]==-1){
                                            int y=i*50,x=j*50;
                                            readimagefile("0.jpg",x,y,x+50,y+50);
                                        }
                                        if(matriceFill[i][j]==1){
                                            int y=i*50,x=j*50;
                                            readimagefile(word[a[i][j]],x,y,x+50,y+50);
                                        }
                                    }
                            }

/********************* DEFEAT ******************/

                            if(a[y/50][x/50]==9){
                                setcolor(4);
                                readimagefile("redbomb.jpg",x,y,x+50,y+50);
                                lose();
                                readimagefile("redbomb.jpg",x,y,x+50,y+50);
                                outtextxy(50,600,"AI PIERDUT");
                                DEFEAT=1;

                            }
                            else
                                readimagefile(word[a[y/50][x/50]],x,y,x+50,y+50);
                            flags[y/50][x/50]=1;
                        }
                    }

/********************* click R ******************/
/********************* on flag ******************/

                    if(GetAsyncKeyState(VK_RBUTTON)){
                        delay(80);
                        round(x,y,50);
                        if(flags[y/50][x/50]==0){
                            delay(30);
                            readimagefile("flag.jpg",x,y,x+50,y+50);
                            flags[y/50][x/50]=-1;
                        }
                    }

/********************* double click R ******************/
/********************* off flag ******************/

                    if(GetAsyncKeyState(VK_RBUTTON)){
                        delay(30);
                        if(GetAsyncKeyState(VK_RBUTTON)){
                            delay(80);
                            round(x,y,50);
                            if(flags[y/50][x/50]==-1){
                                readimagefile("button.jpg",x,y,x+50,y+50);
                                flags[y/50][x/50]=0;
                            }

                        }
                    }
                }

/********************* win Condition ******************/

                bomba=0;
                for(int i=1;i<=10;i++)
                    for(int j=1;j<=10;j++)
                        if(flags[i][j]==a[i][j]-10)
                            bomba++;

                if(bomba==b){
                    for(int i=1;i<=n;i++)
                        for(int j=1;j<=n;j++){
                            int y=i*50,x=j*50;
                            if(flags[i][j]==-1)
                                readimagefile("10.jpg",x,y,x+50,y+50);
                            else
                                readimagefile(word[a[y/50][x/50]],x,y,x+50,y+50);
                        }
                    while(Ai_Castigat){
                        setcolor(rand()%10+1);
                        Sleep(70);
                        outtextxy(50,600,"AI CASTIGAT");
                        if(GetAsyncKeyState(VK_LBUTTON)){
                            GetCursorPos(&currentPosition);
                            x=currentPosition.x;
                            y=currentPosition.y;
                            round(x,y,25);
                            if(x>624&&x<676&&y>624&&y<676)
                                Ai_Castigat=0;
                        }
                    }
                }
            }
        }
        delay(50);
        cleardevice();
    }
    system("pause");
    closegraph();
}

