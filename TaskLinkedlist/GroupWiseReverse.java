package TaskLinkedlist;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class GroupWiseReverse {

    // Function to reverse linked list in groups of size k
    public static Node reverseInGroups(Node head, int k) {
        if (head == null) return null;

        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        // Reverse first k nodes of the list
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Now next points to (k+1)th node, recursively reverse rest of the list
        if (next != null) {
            head.next = reverseInGroups(next, k);
        }

        // prev is the new head of the reversed group
        return prev;
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
        // Creating list: 1->2->3->4->5->6->7->8
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        System.out.print("Original List: ");
        printList(head);

        int k = 3;
        head = reverseInGroups(head, k);

        System.out.print("List after reversing in groups of " + k + ": ");
        printList(head);
    }
}