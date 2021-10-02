#include<iostream>
#ifndef WINBGI_H
#define WINBGI_H
#include<windows.h>
#include<limits.h>
#include<sstream>
//#include<graphics.h>

#endif // WINBGI_H
using namespace std ;
int round(float x)
{
    int a = (int)x ;
    if(x-a < 0.5)
        return a;
    else
        return a+1;
}

int main()
{
    float x1,y1,x2,y2;
    cout<<"Enter Initial Point (x1,y1) : ";
    cin>>x1>>y1;
    cout<<"Enter Final Point (x2,y2) : ";
    cin>>x2>>y2;

    float dx = x2 - x1 ;
    float dy = y2 - y1 ;

    int steps;

    if(abs(dx) > abs(dy))
    {
        steps = abs(dx);
    }
    else
    {
        steps = abs(dy);
    }

    float xInc = dx/steps;
    float yInc = dy/steps;

    int x = x1 ;
    int y = y1 ;

    putpixel(round(x),round(y),1);

    for(int k=1;k<=steps;k++)
    {
        x = x + xInc ;
        y = y + yInc ;

        putpixel(round(x) , round(y) , 1) ;
    }

    return 0 ;
}
