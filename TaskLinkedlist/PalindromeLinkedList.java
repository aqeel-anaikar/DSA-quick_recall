package TaskLinkedlist;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeLinkedList {

    // Function to check if the list is palindrome
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Find middle of the linked list
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalfHead = reverseList(slow);
        Node copySecondHalf = secondHalfHead;

        // Compare first half and second half
        Node firstHalfHead = head;
        while (secondHalfHead != null) {
            if (firstHalfHead.data != secondHalfHead.data) return false;
            firstHalfHead = firstHalfHead.next;
            secondHalfHead = secondHalfHead.next;
        }

        // Restore the list (optional)
        reverseList(copySecondHalf);

        return true;
    }

    // Helper function to reverse the list
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    // Helper function to print list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        System.out.print("Linked List: ");
        printList(head);

        if (isPalindrome(head))
            System.out.println("The linked list is a palindrome.");
        else
            System.out.println("The linked list is not a palindrome.");
    }
}