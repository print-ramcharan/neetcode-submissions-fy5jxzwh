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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<>();
        // Queue<TreeNode> q = new LinkedList<>();
        // if(root != null){
        //     q.add(root);
        // }
        // while(!q.isEmpty()){
        //     int size = q.size();
        //     for(int i = 0 ; i < size; i++){
        //         TreeNode curr = q.poll();

        //         if(root.left != null){
        //             q.add(root.left);
        //         }
        //         if(root.right != null){
        //             q.add(root.right);
        //             rightSideView.add(curr.val);
        //         }
        //     }
        // }
        if(root == null){
            return new ArrayList();
        }
        rightSideView.add(root.val);
        while(root != null){
           
            if(root.right != null){
                 root = root.right;
                rightSideView.add(root.val);
               
                // if(root.left != null){
                // root = root.left;
                // }
            }else{
                root = root.left;
                if(root != null){
                    rightSideView.add(root.val);
                }
                
            }
            
        }
        return rightSideView;
    }
}
