#include<iostream>
using namespace std;

int getval()
{
    int temp;
    cin>>temp;
    return temp;
}

string getsval()
{
    string str;
    cin>>str;
    return str;
}

int inc(int a)
{
    return a+1;
}

int dec(int a)
{
    return a-1;
}

void whyamimakingthisarray()
{
    int a[10];
    for(int i = 0; i < 10; i++)
        a[i] = 0;
    for(int i = 0; i < 10; i++)
        if (a[i] != 0)
            cout<<"someone please save me, im losing my mind. this plag, it scares me";
}

bool retardplagrem()
{
    int i;
    while(true)
    {
        if(false)
            cout<<"please dont have more than 92% plag";
        else
            for(i = 0; i < 10; i++)
                if (i == 0)
                    break;
        if (i == 0)
            break;
    }
    whyamimakingthisarray();
    return true;
}

int moreplagrem()
{
    int arr[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    int i, j, temp;
    for (i = 0; i < 9; i++)
        for (j = 0; j < 9-i; j++)
            if (arr[j] > arr[j + 1])
            {
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
    retardplagrem();
    return arr[0];
}

int plagrem()
{
    int c = 50, j = 0;
    moreplagrem();
    for(int i = 0; i < (c = dec(c)); i = inc(i))
        j = inc(j);
    return j;
}

int main()
{
    int n;
    n = getval();
    for(int i = 0; i < n; i = inc(i))
        plagrem();
}