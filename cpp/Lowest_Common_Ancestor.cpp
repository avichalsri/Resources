/*
Lowest Common Ancestor of a Binary Tree

Problem Statement : Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
Problem Link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

Definition of LCA : The Lowest Common Ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants. Note 
that a node is a descendent of itself.

Example 1 :
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3

Example 2 :
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
 
Example 3 :
Input: root = [1,2], p = 1, q = 2
Output: 1

Please do check out the problem using the problem link to get a graphical representation of the tree.

Constraints :

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.

Idea :
The basic approach here is to do a Depth First Search starting from the root. Whenever we find a node with the given value (p or q) we return that node. 
While backtracking if we find a node whose single child returns a node then we return that node. Else if we find a node whose both child returns 
different nodes this means that the current node is the LCA of both the required nodes ( p and q ) , hence we return the current node. 

My profile link :
https://leetcode.com/abhi__ram/

*/


/*
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(!root) return NULL;
        if(root == p || root == q) return root;
        TreeNode* left = lowestCommonAncestor(root->left, p , q);
        TreeNode* right = lowestCommonAncestor(root->right, p ,q);
        if(left && right){
            return root;
        }
        if(left) {
            return left; 
        }
        if(right){
            return right;
        }
        return NULL;
    }
};
