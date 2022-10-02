// SPOJ Problem
// Problem link:- https://www.spoj.com/problems/AGGRCOW/

// AGGRCOW - Aggressive cows
// #binary-search

// Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).
// His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

// Input
// t – the number of test cases, then t test cases follows.
// * Line 1: Two space-separated integers: N and C
// * Lines 2..N+1: Line i+1 contains an integer stall location, xi

// Output
// For each test case output one integer: the largest minimum distance.

// Example

// Input:
// 1
// 5 3
// 1
// 2
// 8
// 4
// 9

// Output:
// 3

// Output details:
// FJ can put his 3 cows in the stalls at positions 1, 4 and 8,
// resulting in a minimum distance of 3.


/*--------------------SOLUTION----------------------*/

#include <bits/stdc++.h>
using namespace std;

bool isPossible(vector<int> &stalls, int minDist, int k)
{
    int cows=1;               // we already place it at the first available slot i.e stalls[0]  ( GREEDY )
    int lastCowPosition=stalls[0];
    for(int i=1;i<stalls.size();i++)
    {
        if(stalls[i]-lastCowPosition>=minDist)
        {
            cows++;
            lastCowPosition=stalls[i];
            if(cows>=k) return true;
        }
    }
    return false;
}

int aggressiveCows(vector<int> &stalls, int k)
{
    int n=stalls.size();
    sort(stalls.begin(),stalls.end());
    int low=1,high=stalls[n-1]-stalls[0];      // just take low=0 and high = 1000000 any large number if this seems tricky
    int res;
    while(low<=high)
    {
        int mid=(low+high)/2;
        if(isPossible(stalls,mid,k))
        {
            res=mid;
            low=mid+1;
        }
        else high=mid-1;
    }
    return res;
}

int main(){
    int t;
    cin>>t;
    
    while(t--){
        int n,c;
        cin>>n>>c;
        vector<int> stalls(n);
        
        for(int i=0; i<n; i++){
            cin>>stalls[i];
        }

       int ans=  aggressiveCows(stalls, c);
       cout<<ans<<endl;
    }

    return 0;
}