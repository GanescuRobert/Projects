#include <iostream>
#include <graphics.h>

using namespace std;

const int NMAX=20;

extern int a[20][20];
extern int flags[20][20];

int matriceFill[NMAX][NMAX];
int di[4]={-1,0,1,0};
int dj[4]={0,1,0,-1};

bool ok(int i,int j)
{
    if(i<1||j<1||i>10||j>10)
        return false;
    if(matriceFill[i][j]!=0)
        return false;
    return true;
}

void algFill(int x,int y)
{
        matriceFill[x][y]=-1;
        flags[x][y]=1;
        for(int i=0;i<4;i++){
            int nou_i=x+di[i];
            int nou_j=y+dj[i];
            if(ok(nou_i,nou_j)&&a[x][y]==a[nou_i][nou_j] )
                algFill(nou_i,nou_j);
        }
}

int check0(int x,int y)
{
    algFill(x,y);
    cout<<x<<y<<'\n';
    for(int i=1;i<=10;i++)
        for(int j=1;j<=10;j++)
            if(matriceFill[i][j]!=-1&&(
                                         matriceFill[i+1][j]==-1||
                                         matriceFill[i-1][j]==-1||
                                         matriceFill[i][j+1]==-1||
                                         matriceFill[i][j-1]==-1||
                                         matriceFill[i+1][j+1]==-1||
                                         matriceFill[i+1][j-1]==-1||
                                         matriceFill[i-1][j-1]==-1||
                                         matriceFill[i-1][j-1]==-1
                                        )
                )
            {
                matriceFill[i][j]=1;
                flags[i][j]=1;
            }
}
