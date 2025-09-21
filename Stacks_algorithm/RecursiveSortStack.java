// Sort a Stack Recursively — Concept
// Sort the stack by recursively popping elements until empty, then insert each popped element back into the stack in sorted position using a helper function.

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
        if (top == null) return -1;
        int val = top.data;
        top = top.next;
        return val;
    }

    int peek() {
        if (top == null) return -1;
        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }

    // Recursive function to sort the stack
    void sortStack() {
        if (!isEmpty()) {
            int topElem = pop();
            sortStack();
            sortedInsert(topElem);
        }
    }

    // Helper to insert element in sorted order
    void sortedInsert(int val) {
        if (isEmpty() || val > peek()) {
            push(val);
            return;
        }
        int temp = pop();
        sortedInsert(val);
        push(temp);
    }

    void printStack() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class RecursiveSortStack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(30);
        stack.push(10);
        stack.push(20);
        stack.push(5);

        System.out.print("Original Stack: ");
        stack.printStack();

        stack.sortStack();

        System.out.print("Sorted Stack: ");
        stack.printStack();
    }
}