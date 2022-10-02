/*Finding the reverse number of the given integer.

Sample Example:
Enter the number: 235
The reverse of the given integer is: 532
*/

#include <iostream>
using namespace std;

int main(){
    int x;
    cout<<"Enter the number: ";
    cin>>x;
    long b=0;
    int c=0,a;
    long y=x;
    if(y<0){
        y=-y;
        c+=1;
    }
    while(y>0){
        a=y%10;
        b=a+b*10;
        y=y/10;
    }
    if(c>0){
        b*=-1;
    }

    cout<<"The reverse of the given integer is: "<<b;


    return 0;
}

