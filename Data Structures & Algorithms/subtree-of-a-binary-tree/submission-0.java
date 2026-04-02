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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return BFS(root,subRoot);
    }
    public boolean BFS(TreeNode root , TreeNode subroot){
        if(root == null && subroot == null) {
            return true;
        }
        if(root == null || subroot == null) {
            return false;
        }
        if(root.val == subroot.val){
          return (BFS(root.left,subroot.left) &&
            BFS(root.right,subroot.right));
            
        }
        return   (BFS(root.left,subroot) || BFS(root.right,subroot));
        
    }
}
