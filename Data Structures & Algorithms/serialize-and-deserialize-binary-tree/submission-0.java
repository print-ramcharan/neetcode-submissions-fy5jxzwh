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

public class Codec {
      
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
           String inorderEncoded = "";
           String preorderEncoded = "";
          

        if(root != null){
        inorderTraverser(root,inorderEncoded);
        preorderTraverser(root,preorderEncoded);
        }
        return preorderEncoded+"|"+inorderEncoded;
    }
    public void preorderTraverser(TreeNode root, String preorderEncoded){
        if(root == null){
            return ;
        }
        preorderEncoded += root.val+"-" ;
        preorderTraverser(root.left,preorderEncoded);
        preorderTraverser(root.right, preorderEncoded);
        
    }
      public void inorderTraverser(TreeNode root, String inorderEncoded){
        if(root == null){
            return ;
        }
        
        inorderTraverser(root.left, inorderEncoded);
        inorderEncoded += root.val+"-" ;
        inorderTraverser(root.right, inorderEncoded);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] encoded = data.split("\\|");
        String preorderEncoded = encoded[0];
        String inorderEncoded = encoded[1];

        // Remove trailing hyphens and split into arrays
        String[] inorderDecoded = inorderEncoded.replaceAll("-$", "").split("-");
        String[] preorderDecoded = preorderEncoded.replaceAll("-$", "").split("-");

        int[] inorder = Arrays.stream(inorderDecoded)
                              .mapToInt(Integer::parseInt)
                              .toArray();

        int[] preorder = Arrays.stream(preorderDecoded)
                               .mapToInt(Integer::parseInt)
                               .toArray();

        
        return buildTree(preorder, inorder);
    }
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
