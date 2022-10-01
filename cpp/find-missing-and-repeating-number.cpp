// Task : given an array of elements [1..N], in that one number is repeating & one number is missing. Print the missing and repeating number. 
// Do it in time complexity: O(N) , space complexity: O(1) 

#include <bits/stdc++.h> 
using namespace std;

int main(){
    int n,repeating_ele,missing_ele, tot_sum,array_sum=0;
    cout << "Enter number of elements : ";
    cin >> n;
    int arr[n];
    cout << "Enter array elements : ";
    //taking input array
    for(int i=0; i<n; i++){
        cin >> arr[i];
    } 
    //Find the sum of first n natural numbers
    tot_sum= n*(n+1)/2;
    //Find the sum of all elements of array
    for(int i=0; i<n; i++){
        array_sum+= arr[i];
    }
    //for each abs(element), multiply the arr[element] with -1, If its already negative, then the element is repeating.
    for(int i=0; i<n; i++){
        int m = (abs)arr[i];
        if(arr[m] < 0){
            repeating_ele = m;
            break;
        }
        arr[m]*=-1;
    }
    //Now, the missing element = tot_sum - (array_sum - repeating_ele)
    missing_ele = tot_sum - (array_sum - repeating_ele);

    cout << "repeating element : " << repeating_ele << endl;
    cout << "missing eement : " << missing_ele;
   

    return 0;
}