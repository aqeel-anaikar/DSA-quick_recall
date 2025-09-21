package Queue_algorithm;

class Node {
    String task;
    int priority;
    Node next;

    public Node(String task, int priority) {
        this.task = task;
        this.priority = priority;
        this.next = null;
    }
}

public class PriorityQueue {

    Node front;

    public PriorityQueue() {
        front = null;
    }

    // Enqueue node based on priority (higher value means higher priority)
    public void enqueue(String task, int priority) {
        Node newNode = new Node(task, priority);

        // If queue is empty or new node has higher priority than front
        if (front == null || priority > front.priority) {
            newNode.next = front;
            front = newNode;
        } else {
            Node current = front;
            // Traverse until finding right position
            while (current.next != null && current.next.priority >= priority) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        System.out.println("Enqueued: " + task + " with priority " + priority);
    }

    // Dequeue node (highest priority)
    public String dequeue() {
        if (front == null) {
            System.out.println("Priority Queue is empty");
            return null;
        }
        String task = front.task;
        front = front.next;
        return task;
    }

    // Display the queue
    public void display() {
        if (front == null) {
            System.out.println("Priority Queue is empty");
            return;
        }
        Node temp = front;
        System.out.print("Priority Queue: ");
        while (temp != null) {
            System.out.print("[" + temp.task + ", " + temp.priority + "] ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();

        pq.enqueue("Task1", 3);
        pq.enqueue("Task2", 5);
        pq.enqueue("Task3", 1);
        pq.enqueue("Task4", 4);

        pq.display();

        System.out.println("Dequeued: " + pq.dequeue());
        pq.display();
    }
}