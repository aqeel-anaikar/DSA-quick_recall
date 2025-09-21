package TaskLinkedlist;

public class RevLinkedlist {
    class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
        }
    }
    Node head;

    // Function to reverse the linked list
    Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;   // Store next node
            current.next = prev;   // Reverse current node's pointer
            prev = current;        // Move prev to current
            current = next;        // Move to next node
        }
        return prev; // New head after reversal
    }

    // Method to print the linked list
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RevLinkedlist list = new RevLinkedlist();
        list.head = list.new Node(1);
        list.head.next = list.new Node(2);
        list.head.next.next = list.new Node(3);
        list.head.next.next.next = list.new Node(4);

        System.out.print("Original list: ");
        list.printList(list.head);

        list.head = list.reverse(list.head);

        System.out.print("Reversed list: ");
        list.printList(list.head);
    }
}

