

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

     
        TreeNode root = new TreeNode(preorder[0]);

      
        int idx = 0;
        while (inorder[idx] != preorder[0]) {
            idx++;
        }

      
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, idx); 
        int[] rightInorder = Arrays.copyOfRange(inorder, idx + 1, inorder.length); // Right subtree

     
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftInorder.length); // Left subtree
        int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftInorder.length, preorder.length); // Right subtree

      
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}