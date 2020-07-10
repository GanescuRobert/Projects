#include <iostream>
#include <fstream>
using namespace std;

char word[11][15];
void CitirePoze()
{
    ifstream f("charNume.txt" );
    int i=0;
    while(f>>word[i])
        i++;
}

