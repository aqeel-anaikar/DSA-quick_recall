public class QueueUsingNode {
    // Simple Node class to hold data
    private static class Node {
        int data;
        Node next;
       
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
   
    private Node front; // First element to remove
    private Node rear;  // Last element added
    private int size;
   
    public QueueUsingNode() {
        front = null;
        rear = null;
        size = 0;
    }
   
    // Add to end of queue (enqueue)
    public void enqueue(int value) {
        Node newNode = new Node(value);
       
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
   
    // Remove from front of queue (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
       
        int value = front.data;
        front = front.next;
       
        // If queue becomes empty
        if (front == null) {
            rear = null;
        }
       
        size--;
        return value;
    }
   
    // Check front element without removing
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return front.data;
    }
   
    public boolean isEmpty() {
        return size == 0;
    }
   
    public int size() {
        return size;
    }
   
    // Print queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
       
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        QueueUsingNode q = new QueueUsingNode();
       
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display(); // 10 20 30
       
        System.out.println("Dequeued: " + q.dequeue()); // 10
        q.display(); // 20 30
       
        System.out.println("Peek: " + q.peek()); // 20
        q.enqueue(40);
        q.display(); // 20 30 40
    }
}
