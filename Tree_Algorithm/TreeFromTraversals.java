package Tree_Algorithm;

class TreeNode {
    int data;
    TreeNode left, right;
    TreeNode(int data) {
        this.data = data;
        this.left = right = null;
    }
}

public class TreeFromTraversals {
    
    static int preIndex = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        return buildTreeHelper(preorder, inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = search(inorder, inStart, inEnd, rootVal);

        root.left = buildTreeHelper(preorder, inorder, inStart, inIndex - 1);
        root.right = buildTreeHelper(preorder, inorder, inIndex + 1, inEnd);

        return root;
    }

    private static int search(int[] arr, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1; // Should not happen if inputs valid
    }

    // Print Inorder traversal of the constructed tree
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);

        System.out.print("Inorder traversal of constructed tree: ");
        printInorder(root);  // Output: 9 3 15 20 7
    }
}