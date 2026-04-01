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
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        return DFS(root, maxDepth);

    }
    public int DFS(TreeNode root, int maxDepth ){
      
        if(root == null){
            return maxDepth;
        }
        int depthLeft = DFS(root.left, maxDepth +1);
        int depthRight = DFS(root.right, maxDepth +1);

        return Math.max(depthLeft, depthRight);
    }
}
