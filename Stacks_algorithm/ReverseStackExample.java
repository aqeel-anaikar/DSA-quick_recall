package Stacks_algorithm;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    int pop() {
        if (top == null) return -1; // Stack empty
        int data = top.data;
        top = top.next;
        return data;
    }

    boolean isEmpty() {
        return top == null;
    }

    // Function to reverse the stack using recursion
    void reverse() {
        if (!isEmpty()) {
            int temp = pop();
            reverse();
            insertAtBottom(temp);
        }
    }

    // Helper function to insert element at bottom of stack
    void insertAtBottom(int data) {
        if (isEmpty()) {
            push(data);
        } else {
            int temp = pop();
            insertAtBottom(data);
            push(temp);
        }
    }

    // Display stack elements
    void printStack() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class ReverseStackExample {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.print("Original Stack: ");
        stack.printStack();

        stack.reverse();

        System.out.print("Reversed Stack: ");
        stack.printStack();
    }
}
