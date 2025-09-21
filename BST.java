public class BST {
    class node {
        int data;
        node left, right;

        node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    node root = null;

    public void insert(int data) {
        node newnode = new node(data);
        // when First node to create
        if (root == null) {
            root = newnode;
            return;
        }
        // when Root is alredy allocated
        node temproot = root;
        while (true) {
            if (data < temproot.data) {// checking data with root to add in left 
                if (temproot.left == null) { // checking left is null
                    temproot.left = newnode;
                    return;
                }
                temproot = temproot.left;
            } else {
                if (data > temproot.data) {// checking data with root to add in right
                    if (temproot.right == null) { // checking right is null
                        temproot.right = newnode;
                        return;
                    }
                    temproot = temproot.right;
                }
            }
        }

    }
    public void printInorder(){
        System.out.print("Inorder [ ");
        printInorder(root);
    }
    private void printInorder(node temproot){
        if (temproot!=null) {   
            printInorder(temproot.left);
            System.out.print(temproot.data+" ");
            printInorder(temproot.right);
        }
    }
    public void printPreorder(){
        System.out.print("Preorder [ ");
        printPreorder(root);
        System.out.println(" ]");
    }
    private void printPreorder(node temproot){
        if (temproot!=null) {   
            System.out.print(temproot.data+" ");
            printInorder(temproot.left);
            printInorder(temproot.right);
        }
    }
    public void printPostorder(){
        System.out.print("Postorder [ ");
        printPostorder(root);
        System.out.println(" ]");
    }
    private void printPostorder(node temproot){
        if (temproot!=null) {   
            printInorder(temproot.left);
            printInorder(temproot.right);
            System.out.print(temproot.data+" ");
        }
    }

    public boolean search(int key){
        node temproot = root;
        while(temproot!=null){
            if(temproot.data == key){
                return true;
            }
            else if(key < temproot.data)
                temproot = temproot.left;
            else if(key> temproot.data)
                temproot = temproot.right;
            else return false;
        }
        return false;
    }



    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(4);
        tree.insert(5);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(6);
        tree.printInorder();//[1 2 3 4 5 6 ]
        tree.printPreorder();//[1 2 3 4 5 6 ]
        tree.printPostorder();//[1 2 3 4 5 6 ]
    }
}
