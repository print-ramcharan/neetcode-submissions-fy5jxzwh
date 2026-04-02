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
       
       Queue<TreeNode> q = new LinkedList<>();

       if(root != null){
        q.add(root);
       }

       while(!q.isEmpty()){

        int size = q.size();
        for(int i = 0; i < size; i++){
            TreeNode curr = q.poll();

           
            if(curr.left != null){
                if(curr.left.val < curr.val){
                     q.add(curr.left);
                }else{
                    return false;
                } 
            }
            if(curr.right != null){
                if(curr.right.val > curr.val){
                    q.add(curr.right);
                }else{
                    return false;
                } 
            }
        }
       }
       return true;
    }
    
}
