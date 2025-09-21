package Tree_Algorithm;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

public class SerializeDeserializeTree {

    // Serialize tree to string
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private static void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.data).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Deserialize string to tree
    public static TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Index idx = new Index();
        return deserializeHelper(nodes, idx);
    }

    static class Index {
        int value = 0;
    }

    private static TreeNode deserializeHelper(String[] nodes, Index idx) {
        if (idx.value >= nodes.length || nodes[idx.value].equals("#")) {
            idx.value++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[idx.value++]));
        root.left = deserializeHelper(nodes, idx);
        root.right = deserializeHelper(nodes, idx);
        return root;
    }

    // Print inorder (to verify correctness)
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        // Construct example tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serialize
        String serialized = serialize(root);
        System.out.println("Serialized Tree: " + serialized);

        // Deserialize
        TreeNode deserializedRoot = deserialize(serialized);
        System.out.print("Inorder traversal of deserialized tree: ");
        inorder(deserializedRoot);
    }
}