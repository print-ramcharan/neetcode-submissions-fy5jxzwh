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
        BFS(p,q);
        return isSameTree;
    }
    public int BFS(TreeNode root1, TreeNode root2 ){
        if(root1 == null && root2 == null){
            return 0;
        }
        if(root1 == null || root2 == null){
            isSameTree = false;
            return -1;
        }
       
        if(root1.val != root2.val){
            isSameTree = false;
            return -1;
        }
        // if(root1.left != null && root2.left != null){
            // if(root1.val == root2.val){
        int x =  BFS(root1.left, root2.left);
            
            
        // }
        // if(root1.right != null && root2.right != null){
            // if(root1.val == root2.val){}
        int y = BFS(root1.right,root2.right);
        // }
       if(x == -1 || y == -1){
        isSameTree = false;
        return -1;
       }
        return 1;
    }
}
