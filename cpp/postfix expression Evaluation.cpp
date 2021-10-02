#include <iostream>
#include <conio.h>
#include <string.h>
using namespace std;
struct node
{
    int data;
    node *next;
}*p = NULL, *top = NULL, *save = NULL, *ptr;
void push(int x)
{
    p = new node;
    p->data = x;
    p->next = NULL;
    if (top == NULL)
    {
        top = p;
    }
    else
    {
        save = top; 
        top = p;
        p->next = save;
    }
}
char pop()
{
    if (top == NULL)
    {
        cout<<"underflow!!";
    }
    else
    {
        ptr = top;
        top = top->next;
        return(ptr->data);
        delete ptr;
    }
}
int main()
{
    char x[30];
    int a, b;
    cout<<"enter the balanced expression\n";
    cin>>x;
    for (int i = 0; i < strlen(x); i++)
    {
        if (x[i] >= 48 && x[i] <= 57)
            push(x[i]-'0');
        else if (x[i] >= 42 && x[i] <= 47)
        {
            a=pop();
            b=pop();
            switch(x[i])
            {
            case '+':
                push(a+b);
                break;
            case '-':
                push(a-b);
                break;
            case '*':
                push(a*b);
                break;
            case '/':      
                push(a/b);
                break;
            }
        }
    }
    cout<<"ans is "<<pop()<<endl;
    getch();
}