package Tree_Algorithm;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

public class ValidateBST {

    public static boolean isBST(TreeNode root) {
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isBSTUtil(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max)
            return false;
        return isBSTUtil(node.left, min, node.data) && isBSTUtil(node.right, node.data, max);
    }

    public static void main(String[] args) {
        /*
              Construct this tree
                   4
                  / \
                 2   5
                / \
               1   3
        */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println("Is tree BST? " + isBST(root)); // Output: true

        // Modify to create invalid BST
        root.left.right.data = 6;
        System.out.println("After modification, is tree BST? " + isBST(root)); // Output: false
    }
}