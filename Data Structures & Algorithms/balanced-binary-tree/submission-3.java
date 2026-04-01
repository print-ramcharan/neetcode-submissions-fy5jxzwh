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
    public boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
         DFS(root);
        return isBalanced;
    }
    public int DFS(TreeNode root){
        if(root == null){
            return 0;
          
        }
        int leftDepth = DFS(root.left);
        int rightDepth = DFS(root.right);
        if(leftDepth == -1 || rightDepth == -1){
            return -1;
        }

        
        if(Math.abs(leftDepth - rightDepth )> 1){
            isBalanced = false;
            return -1;  
        }
        return Math.max(leftDepth,rightDepth)+1;

    }
}
