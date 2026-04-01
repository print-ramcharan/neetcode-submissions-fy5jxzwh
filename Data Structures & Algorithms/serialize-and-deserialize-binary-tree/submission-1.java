public class Codec {

    public String serialize(TreeNode root) {
        String serialized = "";
        return helper(root, serialized);
    }

    public String helper(TreeNode root, String serialized) {
        if (root == null) {
            return serialized + "null,";
        }
        serialized += root.val + ",";
        serialized = helper(root.left, serialized);
        serialized = helper(root.right, serialized);
        return serialized;
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] index = {0};
        return helperDeserialize(nodes, index);
    }

    private TreeNode helperDeserialize(String[] nodes, int[] index) {
        if (index[0] >= nodes.length || nodes[index[0]].equals("null")) {
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[index[0]++]));
        node.left = helperDeserialize(nodes, index);
        node.right = helperDeserialize(nodes, index);
        return node;
    }
}
