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
    public boolean isValidBST(TreeNode root) {
       
      Stack<TreeNode> stack = new Stack<>();

       if(root != null){
        stack.add(root);
       }

       while(!stack.isEmpty()){

            TreeNode curr = stack.pop();

            if(curr.left != null){
                if(curr.left.val < curr.val){
                     stack.add(curr.left);
                }else{
                    return false;
                } 
            }
            if(curr.right != null){
                if(curr.right.val > curr.val){
                    stack.add(curr.right);
                }else{
                    return false;
                } 
            }
        }
       
       return true;
    }
    
}
