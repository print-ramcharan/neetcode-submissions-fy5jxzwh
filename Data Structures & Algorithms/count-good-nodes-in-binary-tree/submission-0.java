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
    public int maxVal = 0;
    public int goodNodes(TreeNode root) {
        helper(root);
        return goodNodes;

    }
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
      
        if(root.val >= maxVal){
            goodNodes ++;
            maxVal = root.val;
        }

       
       
       
        helper(root.left);
        helper(root.right);
        

    }
    public int max(int a , int b , int c){
        return a>b? a>c? a:c : b>c? b:c;
    }
}
