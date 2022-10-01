/*C++ Program to check whether a number is a Strong Number or not.
Strong Numbers is a number in which the sum of the factorial of individual digits of the numbers is equal to the number itself.
Sample Example:
145
145 = 1! x 4! x 5! =  145

Enter the number: 145
145 is a Strong Number*/

#include <iostream>
using namespace std;

int main (){
    int num;
    cout<<"Enter the number: ";
    cin>>num;
    int digit,sum = 0;
    int temp=num;
    while(temp!=0){
        digit = temp % 10;
        int fact = 1;
        for(int i = 1; i <= digit; i++){
            fact = fact * i;
        }
        sum = sum + fact;
        temp /= 10;
    }
    if(sum==num){
        cout << num << " is a Strong Number";
    }
    else{
        cout << num << " is not a Strong Number";
    }
}

