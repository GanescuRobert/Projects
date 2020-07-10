#include <cstdlib>
#include <ctime>
#include <cstring>
#include <iostream>

using namespace std;

extern int n,b;
int a[20][20];
bool check(int i,int j){
    if(a[i][j]==9)
        return 1;
    return 0;
}

int checkAll(int i,int j){
    int k=0;
    k+=check(i+1,j-1)+check(i+1,j)+check(i+1,j+1)+check(i,j-1)+check(i,j+1)+check(i-1,j)+check(i-1,j-1)+check(i-1,j+1);
    return k;
}

int bombe(int b){
    int x,y;
    srand(time(0));
    while(b!=0){
        x=rand()%n+1;
        y=rand()%n+1;
        if(a[x][y]!=9){
            a[x][y]=9;
        }
        else
            b++;
        b--;
    }
}

void Matrice(){
    srand(time(0));
    bombe(b);
    for(int i=1;i<=n;i++)
        for(int j=1;j<=n;j++)
            if(a[i][j]!=9)
                a[i][j]=checkAll(i,j);
}
