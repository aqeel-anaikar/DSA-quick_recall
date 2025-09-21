package Tree_Algorithm;

class TreeNode {
    int data;
    TreeNode left, right;
    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// Node class for queue
class Node {
    TreeNode treeNode;
    Node next;
    Node(TreeNode treeNode) {
        this.treeNode = treeNode;
        this.next = null;
    }
}

// Node-based Queue for TreeNodes
class Queue {
    Node front, rear;

    void enqueue(TreeNode node) {
        Node temp = new Node(node);
        if (rear == null) {
            front = rear = temp;
            return;
        }
        rear.next = temp;
        rear = temp;
    }

    TreeNode dequeue() {
        if (front == null) return null;
        TreeNode node = front.treeNode;
        front = front.next;
        if (front == null) rear = null;
        return node;
    }

    boolean isEmpty() {
        return front == null;
    }
}

public class BinaryTreeLevelOrder {

    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) return;

        Queue queue = new Queue();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.dequeue();
            System.out.print(current.data + " ");

            if (current.left != null)
                queue.enqueue(current.left);

            if (current.right != null)
                queue.enqueue(current.right);
        }
    }

    public static void main(String[] args) {
        /* Construct this binary tree
                 1
                / \
               2   3
              / \   \
             4   5   6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.print("Level-order traversal: ");
        levelOrderTraversal(root);
    }
}

