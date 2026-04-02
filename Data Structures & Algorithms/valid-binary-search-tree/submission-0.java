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
    public boolean isValidBST=true;
    public TreeNode root;
    public boolean isValidBST(TreeNode root) {
        this.root = root;
        DFS(root);
        return isValidBST;
    }
    public void DFS(TreeNode root){
        if(root == null){
            return ;
        }

        if(root.left != null){
             if( this.root.val < root.left.val){
                isValidBST = false;
            }
        }
        if(root.right != null){
           if(this.root.val > root.right.val){
            isValidBST = false;
           }
        }
        DFS(root.left);
        DFS(root.right);
    }
}
