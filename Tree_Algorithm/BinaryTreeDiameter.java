package Tree_Algorithm;

class TreeNode {
    int data;
    TreeNode left, right;
    TreeNode(int data) {
        this.data = data;
        this.left = right = null;
    }
}

public class BinaryTreeDiameter {

    static class Height {
        int value;
    }

    // Returns diameter and updates height simultaneously
    public static int diameter(TreeNode root, Height height) {
        if (root == null) {
            height.value = 0;
            return 0;
        }

        Height leftHeight = new Height();
        Height rightHeight = new Height();

        // Get diameters of left and right subtrees
        int leftDiameter = diameter(root.left, leftHeight);
        int rightDiameter = diameter(root.right, rightHeight);

        // Current node height
        height.value = 1 + Math.max(leftHeight.value, rightHeight.value);

        // Max diameter passing through current node
        int currentDiameter = leftHeight.value + rightHeight.value + 1;

        // Return max of left, right diameters and current diameter
        return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
    }

    public static void main(String[] args) {
        /*
                Construct this tree
                     1
                    / \
                   2   3
                  / \    
                 4   5 
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Height height = new Height();
        int diameter = diameter(root, height);
        System.out.println("Diameter of the tree is: " + diameter);
    }
}