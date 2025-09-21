package Queue_algorithm;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front, rear;
    int size;

    Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    void enqueue(int x) {
        Node node = new Node(x);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    int dequeue() {
        if (front == null) return -1;
        int val = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return val;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int getSize() {
        return size;
    }

    void display() {
        Node curr = front;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

public class InterleaveQueueHalves {

    public static void interleaveQueue(Queue queue) {
        if (queue.size % 2 != 0) {
            System.out.println("Queue size should be even for perfect interleaving.");
            return;
        }

        int halfSize = queue.size / 2;
        Queue firstHalf = new Queue();
        Queue secondHalf = new Queue();

        // Split original queue into two halves
        for (int i = 0; i < halfSize; i++) {
            firstHalf.enqueue(queue.dequeue());
        }
        for (int i = 0; i < halfSize; i++) {
            secondHalf.enqueue(queue.dequeue());
        }

        // Interleave elements back into original queue
        while (!firstHalf.isEmpty() && !secondHalf.isEmpty()) {
            queue.enqueue(firstHalf.dequeue());
            queue.enqueue(secondHalf.dequeue());
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        // Add elements (even number count)
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        System.out.print("Original Queue: ");
        queue.display();

        interleaveQueue(queue);

        System.out.print("Interleaved Queue: ");
        queue.display();
    }
}