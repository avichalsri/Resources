/*
LEETCODE PROBLEM BINARY TREE LEVEL ORDER TRAVERSAL(102)(MEDIUM)

Problem statement: Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
*/

//Please change the name of class a per to whatever has been mentioned on leetcode


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class LevelOrder {
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> sub = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode cur=q.remove();
                sub.add(cur.val);
            if(cur.left!=null){
                q.add(cur.left);
            }
            if(cur.right!=null){
                q.add(cur.right);
            }
            }
            result.add(sub);
        }
        return result;
    }
}