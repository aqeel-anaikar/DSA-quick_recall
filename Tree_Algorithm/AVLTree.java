package Tree_Algorithm;

class TreeNode {
    int key, height;
    TreeNode left, right;

    TreeNode(int key) {
        this.key = key;
        height = 1;
    }
}

public class AVLTree {
    
    // Get height of node
    int height(TreeNode node) {
        return (node == null) ? 0 : node.height;
    }

    // Get balance factor
    int getBalance(TreeNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    // Right rotate (LL)
    TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotate (RR)
    TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Insert key and balance the tree
    TreeNode insert(TreeNode node, int key) {
        if (node == null) return new TreeNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // duplicate keys not allowed
            return node;

        // Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get balance factor
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Preorder traversal to check tree structure
    void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        TreeNode root = null;

        int[] keys = {10, 20, 30, 40, 50, 25};

        for (int key : keys) {
            root = tree.insert(root, key);
        }

        System.out.print("Preorder traversal of AVL tree is: ");
        tree.preOrder(root);
    }
}