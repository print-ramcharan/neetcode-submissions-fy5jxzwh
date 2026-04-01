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
    public int goodNodes=0;
    public int goodNodes(TreeNode root) {
        int maxVal = Integer.MIN_VALUE;
        helper(root,maxVal);
        return goodNodes;

    }
    public void helper(TreeNode root,int maxVal){
        if(root == null){
            return;
        }
      
        if(root.val >= maxVal){
            goodNodes ++;
            maxVal = root.val;
        }
    
        helper(root.left,maxVal);
        helper(root.right,maxVal);
        

    }
    
}
