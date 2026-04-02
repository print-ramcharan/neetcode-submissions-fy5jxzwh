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
    public int maxPathSum = 0;
    public int maxPathSum(TreeNode root) {
        dfs(root);
      return maxPathSum;
    }
    private void dfs(TreeNode root){

        if(root == null){
            return; 
        }
        int tempSum= 0;
        if(root.left != null && root.right != null){
            tempSum = root.left.val + root.right.val +root.val;
            if(tempSum > maxPathSum){
                maxPathSum = tempSum;
            }
        }else if(root.left != null && root.right == null){
            tempSum = root.left.val + root.val;
            if(tempSum > maxPathSum ){
             maxPathSum = tempSum;
            }
        }else if(root.left == null && root.right != null){
            tempSum = root.right.val + root.val;
            if(tempSum > maxPathSum ){
             maxPathSum = tempSum;
            }
        }
        else{
            tempSum = root.val;
            if(root.val > maxPathSum || maxPathSum == 0){
                maxPathSum = root.val;
            }
        }
        // if(maxPathSum == 0){
        //     maxPathSum = root.val;
        // }else if(tempSum > maxPathSum ){
        //      maxPathSum = tempSum;
        // }
        
         dfs(root.left);
         dfs(root.right);
        
    }
}
