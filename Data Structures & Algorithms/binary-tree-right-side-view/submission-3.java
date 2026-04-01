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
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null){
            q.add(root);
            // rightSideView.add(root.val);
        }

    //     1 \/
    //    / \
    //   2   3
    //  / \ / \
    // 4  5 6  7
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                TreeNode curr = q.poll();

               
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                    
                }
                if (i == size - 1) {
                    rightSideView.add(curr.val);
                }
                
            //    if(curr.right == null){
            //     if(curr.left != null){
            //         rightSideView.add(curr.left.val);
            //     } 
            //    }else{
                 
            //     rightSideView.add(curr.right.val);
            //    }
                
                
                // else{
                //     if(curr.right == null){
                //         rightSideView.add(curr.val);
                //     }
                    
                // }
                
               
            }
            
        }
        // if(root == null){
        //     return new ArrayList();
        // }
        // rightSideView.add(root.val);
        // while(root != null){
           
        //     if(root.right != null ){
        //             root = root.right;
        //             rightSideView.add(root.val);
        //         }else{
        //             root = root.left;
        //         }
        //     }else{
        //         root = root.left;
        //         if(root != null){
        //             rightSideView.add(root.val);
        //         }
        
        //     }
            
        // }
        return rightSideView;
    }
}
