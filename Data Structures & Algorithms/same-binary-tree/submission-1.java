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

class Solution {
    public boolean isSameTree = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
       return BFS(p,q);
       
    }
    public boolean BFS(TreeNode root1, TreeNode root2 ){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
           return false;
        }
       
        if(root1.val != root2.val){
            return false;
        }
      
        return (BFS(root1.left, root2.left) && BFS(root1.right,root2.right));
     
    }
}
