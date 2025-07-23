import java.util.*;

class bst {
    class node {
        int key;
        node left, right;

        public node(int item) {
            key = item;
            left = right = null;
        }
    }

    node root;

    bst() {
        root = null;
    }

    // Tree insert
    void insert(int key) {
        root = insertRec(root, key);
    }

    node insertRec(node root, int key) {
        if (root == null) {
            root = new node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    // In-order
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Pre-Order
    void preorder() {
        preorderRec(root);
    }

    void preorderRec(node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Post-Order
    void postorder() {
        postorderRec(root);
    }

    void postorderRec(node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Search Function
    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        if (root.key > key)
            return searchRec(root.left, key);
        return searchRec(root.right, key);
    }

    // Delete Function
    void delete(int key) {
        root = deleteRec(root, key);
    }

    node deleteRec(node root, int key) {
        if (root == null)
            return root;
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    // Min Value Function
    int minValue(node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

}

public class BST {
    public static void main(String[] args) {
        bst b = new bst();
        Scanner sc = new Scanner(System.in);
        // insert nodes
        System.out.print("Enter Test Case: ");
        int test_case = sc.nextInt();
        int value;
        for (int i = 0; i < test_case; i++) {
            System.out.print("Enter value" + i + ":");
            value = sc.nextInt();
            b.insert(value);
            System.out.println();
        }
        // print in order of tree
        System.out.println("Inorder Travesal of the tree");
        b.inorder();
        // Print preorder traversal of the tree
        System.out.println("\nPreorder traversal of the tree: ");
        b.preorder();

        // Print postorder traversal of the tree
        System.out.println("\nPostorder traversal of the tree: ");
        b.postorder();
        // Search for a key
        int key = 40;
        if (b.search(key))
            System.out.println("\n" + key + " found in the tree.");
        else
            System.out.println("\n" + key + " not found in the tree.");
        // Delete node 20
        b.delete(20);
        System.out.println("\nInorder traversal of the modified tree afterdeletion of 20: ");
    }
}
