package Queue_algorithm;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Node-based Queue
class Queue {
    Node front, rear;

    void enqueue(int x) {
        Node temp = new Node(x);
        if (rear == null) {
            front = rear = temp;
            return;
        }
        rear.next = temp;
        rear = temp;
    }

    int dequeue() {
        if (front == null) return -1;
        int val = front.data;
        front = front.next;
        if (front == null) rear = null;
        return val;
    }

    boolean isEmpty() {
        return front == null;
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

// Node-based Stack
class Stack {
    Node top;

    void push(int x) {
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
    }

    int pop() {
        if (top == null) return -1;
        int val = top.data;
        top = top.next;
        return val;
    }

    boolean isEmpty() {
        return top == null;
    }
}

public class QueueReversalWithNodes {

    // Reverse queue using stack
    public static void reverseQueue(Queue queue) {
        Stack stack = new Stack();

        // Dequeue all elements and push into stack
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }

        // Pop all elements from stack and enqueue back to queue
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.print("Original Queue: ");
        queue.display();

        reverseQueue(queue);

        System.out.print("Reversed Queue: ");
        queue.display();
    }
}