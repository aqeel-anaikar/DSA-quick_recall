package Queue_algorithm;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedQueue {
    Node front, rear;

    void enqueue(int data) {
        Node node = new Node(data);
        if (rear == null) {
            front = rear = node;
            return;
        }
        rear.next = node;
        rear = node;
    }

    int dequeue() {
        if (front == null) return -1;
        int val = front.data;
        front = front.next;
        if (front == null) rear = null;
        return val;
    }

    boolean isLoopPresent() {
        Node slow = front;
        Node fast = front;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // cycle detected
            }
        }
        return false; // no cycle
    }
}

public class QueueLoopDetection {

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println("Loop present? " + queue.isLoopPresent());

        // Creating a loop manually for testing
        // connecting rear.next to front (cycle)
        if (queue.rear != null && queue.front != null) {
            queue.rear.next = queue.front; // cycle formed
        }

        System.out.println("Loop present after creating cycle? " + queue.isLoopPresent());
    }
}