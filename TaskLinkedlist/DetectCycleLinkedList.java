package TaskLinkedlist;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DetectCycleLinkedList {

    // Function to detect cycle using Floyd's algorithm
    public static boolean hasCycle(Node head) {
        if (head == null) return false;
        
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // Move slow by one
            fast = fast.next.next;      // Move fast by two

            if (slow == fast) {         // Cycle detected
                return true;
            }
        }
        return false;   // No cycle
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        
        // Creating a cycle here for testing (4 -> 2)
        head.next.next.next.next = head.next;

        if (hasCycle(head)) {
            System.out.println("Cycle detected in the linked list.");
        } else {
            System.out.println("No cycle detected in the linked list.");
        }
    }
}
