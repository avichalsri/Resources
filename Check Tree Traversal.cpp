/*
Link to question: https://practice.geeksforgeeks.org/problems/cb02d40f50b0113c47cd9036e5f340bb51b32289/1
Given Preorder, Inorder and Postorder traversals of some tree of size N. The task is to check if they are all of the same tree or not.

Example 1:

Input:
N = 5
preorder[] = {1, 2, 4, 5, 3}
inorder[] = {4, 2, 5, 1, 3}
postorder[] = {4, 5, 2, 3, 1}
Output: Yes
Explanation: 
All of the above three traversals 
are of the same tree.
           1
         /   \
        2     3
      /   \
     4     5 
*/

// Source Code

#include <bits/stdc++.h> 
using namespace std; 

class Solution{
    public:
    bool checktree(int preorder[], int inorder[], int postorder[], int N) 
    { 
    	if(N == 0)
    	return 1;
    	
    	if(N == 1)
    	return ((preorder[0] == inorder[0]) && (inorder[0] == postorder[0]));
    	int idx = -1;
    	for(int i = 0 ; i < N ; i++)
    	{
    	    if(inorder[i] == preorder[0])
    	    {
    	        idx = i;
    	        break;
    	    }
    	}
    	   
    	    if(idx == -1)
    	        return false;
    	    if(preorder[0] != postorder[N-1]) return false;
    	    int ret1 = checktree(preorder + 1, inorder, postorder, idx);
    	    int ret2 = checktree(preorder + idx + 1, inorder + idx + 1, postorder + idx ,N - idx - 1);
    	    return (ret1 && ret2);
    	
    } 

};
int main() 
{ 
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		int preorder[n];
		int inorder[n];
		int postorder[n];

		for (int i = 0; i < n; ++i)
			cin>>preorder[i];

		for (int i = 0; i < n; ++i)
			cin>>inorder[i];

		for (int i = 0; i < n; ++i)
			cin>>postorder[i];
        
        Solution obj;
		if(obj.checktree(preorder, inorder, postorder, n))
			cout << "Yes\n";
		else
			cout<<"No\n";
	} 
	return 0; 
}
