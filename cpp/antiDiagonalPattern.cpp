#include<bits/stdc++.h>
using namespace std;

//Problem Statement :  You are given a  square matrix of size N*N, return an array of its anti-diagonals. 
//Example1 : matrix[][] = {{1,2,3},
//			{4,5,6},
//			{7,8,9}}
//  Solution :  For the Above Matrix Anti-Diagonal Pattern is : 1,2,4,3,5,7,6,8,9
// Example2 : matrix[] = {{1,2},
//			{4,5}}
//  Solution :        For the Above Matrix Anti-Diagonal Pattern is : 1,2,4,5


vector<int> antiDiagonalPattern(vector<vector<int>>&matrix) 
    {
        vector<pair<int,int>>arr;
        int n = matrix.size();
        int m= matrix[0].size();
       
       for(int j  = 0;j<m;j++){
           arr.push_back({0,j});
       }
        for(int i = 1;i<n;i++){
           arr.push_back({i,m-1});
       }
       vector<int>temp;
       for(auto x : arr){
           int i = x.first;
           int j = x.second;
           
           while(i<n && j>=0){
               temp.push_back(matrix[i][j]);
               i++;
               j--;
           }
       }
       return temp;
    }
    
    

void print(vector<int>&arr){
	for(auto x : arr){
	
			cout<<x<<" ";
	}
}


int main(){
    vector<vector<int>>matrix;
    int n;
    cin>>n;
    for(int i = 0;i<n;i++){
    	vector<int>temp;
    	for(int j = 0;j<n;j++){
    		int val ;
    		cin>>val;
    		temp.push_back(val);
		}
		matrix.push_back(temp);
	}
    vector<int>ans;
	ans = antiDiagonalPattern(matrix);
	cout<<"AntiDiagonal Pattern   : \n";
	print(ans);
	return 0;
}
