package TaskLinkedlist;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeSortedLists {

    // Function to merge two sorted linked lists
    public static Node mergeTwoLists(Node l1, Node l2) {
        // Dummy node to help in merging
        Node dummy = new Node(0);
        Node tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // If any nodes left in l1 or l2, append them
        if (l1 != null) tail.next = l1;
        else tail.next = l2;

        return dummy.next; // Head of merged sorted list
    }

    // Method to print linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // List 1: 1 -> 3 -> 5
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);

        // List 2: 2 -> 4 -> 6
        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);

        System.out.print("List 1: ");
        printList(l1);

        System.out.print("List 2: ");
        printList(l2);

        Node merged = mergeTwoLists(l1, l2);
        System.out.print("Merged List: ");
        printList(merged);
    }
}

