package TaskLinkedlist;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class IntersectionOfLists {

    public static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

        Node pointerA = headA;
        Node pointerB = headB;

        // Traverse both lists; when one reaches end, redirect it to the other list's head
        while (pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        return pointerA;  // Either the intersection node or null if no intersection
    }

    public static void main(String[] args) {
        // Create first list: 1->2->3->4->5
        Node headA = new Node(1);
        headA.next = new Node(2);
        headA.next.next = new Node(3);
        headA.next.next.next = new Node(4);
        headA.next.next.next.next = new Node(5);

        // Create second list: 9->4->5
        Node headB = new Node(9);
        headB.next = headA.next.next.next;  // Intersection at node with value 4

        Node intersection = getIntersectionNode(headA, headB);
        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.data);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
