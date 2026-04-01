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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode x = root;

        while(x != null){
            if(x.val > p.val && x.val > q.val){
                x=x.left;
            }else if(x.val < p.val && x.val < q.val){
                x= x.right;
            }else{
                return x;
            }
        }
        return null;
    }
}
   
