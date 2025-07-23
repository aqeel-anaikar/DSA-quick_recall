public class StackUsingArray {
    private int[] stack;
    private int top;
    private int capacity;

    // Initialize stack with default size 10
    public StackUsingArray() {
        this(10);
    }

    // Initialize stack with custom size
    public StackUsingArray(int size) {
        this.stack = new int[size];
        this.capacity = size;
        this.top = -1; // Stack is initially empty
    }

    // Push element onto stack
    public void push(int value) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        stack[++top] = value;
    }

    // Pop element from stack
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[top--];
    }

    // Peek at top element
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Get current stack size
    public int size() {
        return top + 1;
    }

    // Print stack contents
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(5);
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        stack.printStack(); // Stack (top to bottom): 30 20 10 
        
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Top element: " + stack.peek()); // 20
        System.out.println("Stack size: " + stack.size()); // 2
    }
}