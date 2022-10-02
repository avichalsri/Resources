// Question : Smallest subarray with sum greater than x
// Question link : https://practice.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1#
// Solved by using two pointer approach

#include<bits/stdc++.h>
using namespace std;

class Solution{
  public:
  int smallestSubWithSum(int arr[], int n, int x)
    {   
        int i=0,j=0,sum=0;
        // minVal variable stores the minimum size subarray 
        int minVal=INT_MAX;
        while(i<=j && j<n){
            while(sum<=x && j<n){
                sum += arr[j++];
            }
            while(sum>x && i<j){
                minVal = min(minVal,j-i);
                sum-=arr[i];
                i++;
            }
        }
        return minVal;
    }
};

int main(){
  int t;
  cin>>t;
  while(t--){
    int n,x;
    cin>>n>>x;
    int arr[n];
    for(int i=0;i<n;i++)cin>>arr[i];
    Solution s;
    cout<<s.smallestSubWithSum(arr,n,x)<<"\n";
  }
  return 0;
}
