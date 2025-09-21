package Queue_algorithm;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularQueue {
    Node rear;

    public CircularQueue() {
        rear = null;
    }

    // Enqueue in circular queue
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            rear = newNode;
            rear.next = rear;
        } else {
            newNode.next = rear.next;
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Dequeue front node and return its data
    public int dequeue() {
        if (rear == null) return -1;

        Node front = rear.next;
        if (rear == front) { // Only one node
            int val = front.data;
            rear = null;
            return val;
        }
        rear.next = front.next;
        return front.data;
    }

    // Move front element to rear (simulate rotation)
    public void rotate() {
        if (rear != null) {
            rear = rear.next;
        }
    }

    // Check if only one node present
    public boolean hasOneNode() {
        return rear != null && rear.next == rear;
    }
}

public class JosephusNodeQueue {

    public static int josephus(int n, int k) {
        CircularQueue queue = new CircularQueue();

        // Enqueue n people
        for (int i = 1; i <= n; i++) {
            queue.enqueue(i);
        }

        while (!queue.hasOneNode()) {
            // Rotate k-1 times
            for (int i = 1; i < k; i++) {
                queue.rotate();
            }
            // Eliminate k-th person
            int eliminated = queue.dequeue();
            System.out.println("Eliminated: " + eliminated);
        }

        return queue.dequeue();
    }

    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int survivor = josephus(n, k);
        System.out.println("Survivor is person: " + survivor);
    }
}