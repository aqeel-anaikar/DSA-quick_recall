package TaskLinkedlist;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MiddleNodeLinkedList {

    // Function to find and return the middle node of the linked list
    public static Node findMiddle(Node head) {
        if (head == null) return null;

        Node slow = head;
        Node fast = head;

        // Move fast pointer twice as fast as slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;          // move slow by one
            fast = fast.next.next;     // move fast by two
        }
        return slow; // slow is at middle
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node mid = findMiddle(head);
        if (mid != null) {
            System.out.println("Middle node value is: " + mid.data);
        } else {
            System.out.println("The list is empty.");
        }
    }
}

