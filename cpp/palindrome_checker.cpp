/* Check whether the given number is a palindrome or not.

   Sample Example:
   
   Enter the Number: 2354
   The given number is not a Palindrome

   Enter the Number: 24542
   The given number is a Palindrome
*/
#include <iostream>
using namespace std;
int main(){
    int n,a,sum=0,b;
    cout<<"Enter the Number: ";
    cin>>n;
    a=n;
    while(n>0){
        b=n%10;
        sum=(sum*10)+b;
        n=n/10;
    }
    if(a==sum){
        cout<<"The given number is a Palindrome";
    }
    else{
        cout<<"The given number is not a Palindrome";
    }
    return 0;
}

