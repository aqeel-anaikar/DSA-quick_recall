package TaskLinkedlist;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveDuplicatesUnsortedSLL {

    // Function to remove duplicates without extra space
    public static void removeDuplicates(Node head) {
        Node current = head;

        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next; // Remove duplicate node
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    // Helper method to print linked list
    public static void printList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(12);
        head.next.next = new Node(11);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(12);
        head.next.next.next.next.next = new Node(11);
        head.next.next.next.next.next.next = new Node(10);

        System.out.print("Original List: ");
        printList(head);

        removeDuplicates(head);

        System.out.print("List after removing duplicates: ");
        printList(head);
    }
}

