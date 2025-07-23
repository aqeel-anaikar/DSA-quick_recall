public class StackUsingNode {

    private static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node top; // Only need to track the top node
    private int size;
    
    public StackUsingNode() {
        top = null;
        size = 0;
    }
    
    // Push element onto stack
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top; // New node points to current top
        top = newNode;      // Update top to new node
        size++;
    }
    
    // Pop element from stack
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int value = top.data;
        top = top.next; // Move top to next node
        size--;
        return value;
    }
    
    // Peek at top element
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }
    
    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }
    
    // Get stack size
    public int size() {
        return size;
    }
    
    // Print stack contents
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack (top to bottom): ");
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        StackUsingNode stack = new StackUsingNode();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        stack.printStack(); // Stack (top to bottom): 30 20 10 
        
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Top element: " + stack.peek()); // 20
        System.out.println("Stack size: " + stack.size()); // 2
    }
}