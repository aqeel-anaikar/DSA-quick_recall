package TaskLinkedlist;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class PairwiseSwapNodes {

    // Recursive function to swap nodes in pairs
    public static Node pairwiseSwap(Node head) {
        if (head == null || head.next == null)
            return head;

        Node firstNode = head;
        Node secondNode = head.next;

        // Swapping
        firstNode.next = pairwiseSwap(secondNode.next);
        secondNode.next = firstNode;

        // Now the second node is the new head of the swapped pair
        return secondNode;
    }

    // Helper function to print linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating list: 1->2->3->4->5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Original List: ");
        printList(head);

        head = pairwiseSwap(head);

        System.out.print("List after pairwise swap: ");
        printList(head);
    }
}