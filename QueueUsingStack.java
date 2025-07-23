import java.util.Stack;
public class QueueUsingStack {
    private Stack<Integer> stack1; // For enqueue operations
    private Stack<Integer> stack2; // For dequeue operations


    public QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }


    // Add to queue (enqueue)
    public void enqueue(int item) {
        stack1.push(item);
    }


    // Remove from queue (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
       
        // If stack2 is empty, transfer all elements from stack1
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
       
        return stack2.pop();
    }


    // Check front element without removing
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
       
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
       
        return stack2.peek();
    }


    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }


    public int size() {
        return stack1.size() + stack2.size();
    }


    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();
       
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
       
        System.out.println("Dequeued: " + q.dequeue()); // 10
        System.out.println("Peek: " + q.peek());       // 20
       
        q.enqueue(40);
        System.out.println("Dequeued: " + q.dequeue()); // 20
        System.out.println("Dequeued: " + q.dequeue()); // 30
        System.out.println("Dequeued: " + q.dequeue()); // 40
        System.out.println("Dequeued: " + q.dequeue()); // Queue is empty! -1
    }
}

