public class QueueUsingArray {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;


    // Initialize queue with a fixed size
    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }


    // Add an element to the queue (enqueue)
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        rear++;
        queue[rear] = item;
        size++;
    }


    // Remove an element from the queue (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1; // Indicates empty queue
        }
        int item = queue[front];
        front++;
        size--;
        return item;
    }


    // Check the front element without removing
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queue[front];
    }


    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }


    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }


    // Get current queue size
    public int size() {
        return size;
    }


    // Display queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        QueueUsingArray q = new QueueUsingArray(5);


        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display(); // Queue: 10 20 30


        System.out.println("Dequeued: " + q.dequeue()); // 10
        q.display(); // Queue: 20 30


        System.out.println("Peek: " + q.peek()); // 20
        q.enqueue(40);
        q.enqueue(50);
        q.display(); // Queue: 20 30 40 50
    }
}