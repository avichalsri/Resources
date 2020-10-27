#include<iostream>
#include<stdio.h>
using namespace std;
#include<conio.h>
#define INFINITY 999
struct node
{
    int cost;
    int value;
    int from;
}a[7];
void min_heapify(int *b, int i, int n)
{
    int j, temp;
    temp = b[i];
    j = 2 * i;
    while (j <= n)
    {
        if (j < n && b[j + 1] < b[j])
        {
            j = j + 1;
        }
        if (temp < b[j])
        {
            break;
        }
        else if (temp >= b[j])
        {
            b[j / 2] = b[j];
            j = 2 * j;
        }
    }
    b[j / 2] = temp;
    return;
}
void build_minheap(int *b, int n)
{
    int i;
    for(i = n / 2; i >= 1; i--)
    {
        min_heapify(b, i, n);
    }
}
void addEdge(int am[][7], int src, int dest, int cost)
{
     am[src][dest] = cost;
     return;
}
void bell(int am[][7])
{
    int i, j, k, c = 0, temp;
    a[0].cost = 0;
    a[0].from = 0;
    a[0].value = 0;
    for (i = 1; i < 7; i++)
    {
        a[i].from = 0;
        a[i].cost = INFINITY;
        a[i].value = 0;
    }
    while (c < 7)
    {
        int min = 999;
        for (i = 0; i < 7; i++)
        {
            if (min > a[i].cost && a[i].value == 0)
            {
                min = a[i].cost;
            }
            else
            {
                continue;
            }
        }
        for (i = 0; i < 7; i++)
        {
            if (min == a[i].cost && a[i].value == 0)
            {
                break;
            }
            else
            {
                continue;
            }
        }
        temp = i;
        for (k = 0; k < 7; k++)
        {
            if (am[temp][k] + a[temp].cost < a[k].cost)
            {
                a[k].cost = am[temp][k] + a[temp].cost;
                a[k].from = temp;
            }
            else
            {
                continue;
            }
        }
        a[temp].value = 1;
        c++;
    }
    cout<<"Cost"<<"\t"<<"Source Node"<<endl; 
    for (j = 0; j < 7; j++)
    {
        cout<<a[j].cost<<"\t"<<a[j].from<<endl;
    }
}
int main()
{
    int n, am[7][7], c = 0, i, j, cost;
    for (int i = 0; i < 7; i++)
    {
        for (int j = 0; j < 7; j++)
        {
            am[i][j] = INFINITY;
        }
    }
    while (c < 12)
    {
        cout<<"Enter the source, destination and cost of edge\n";
        cin>>i>>j>>cost;
        addEdge(am, i, j, cost);
        c++;
    }
    bell(am);
    getch();
}