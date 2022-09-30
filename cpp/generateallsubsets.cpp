#include<bits/stdc++.h>
using namespace std;
//Given an integer array, generate all possible subsets of that array
//Example: Array: {1,2,3}
/*
Output:
{},{1},{2},{3},{1,2},{1,3},{2,3},{1,2,3}
*/
vector<vector<int>> subsets;
//Recursive fucntion to generate all subsets. Time complexity: 2^n(2 to the power n)
void gensubset(vector<int> &v, int i, vector<int> &temp)
{
    if(i==v.size())
    {
        subsets.push_back(temp);
        return;
    }

    //For every element, we can either take the element in the subset, or ignore it.
    gensubset(v,i+1, temp);
    temp.push_back(v[i]);
    gensubset(v,i+1, temp);
    temp.pop_back();
}

int main(){
    //Taking input of size of array
    int n;
    cin>>n;
    vector<int> v(n);
    //Taking input of array
    for(int i=0;i<n;i++)
    {
        cin>>v[i];
    }
    vector<int> temp;
    gensubset(v, 0, temp);//calling recursive function to generate all subsets
    //Printing all subsets
    for(int i=0;i<subsets.size();i++)
    {
        for(int j=0;j<subsets[i].size();j++)
        {
            cout<<subsets[i][j]<<" ";
        }
        cout<<endl;
    }
    return 0;
}
