package Stacks_algorithm;

class Node {
    int data;
    int min;
    Node next;
    Node(int data, int min) {
        this.data = data;
        this.min = min;
        this.next = null;
    }
}

class MinStack {
    Node top;

    void push(int x) {
        if (top == null) {
            top = new Node(x, x);
        } else {
            int currentMin = Math.min(x, top.min);
            Node newNode = new Node(x, currentMin);
            newNode.next = top;
            top = newNode;
        }
    }

    int pop() {
        if (top == null) return -1; // Stack empty
        int val = top.data;
        top = top.next;
        return val;
    }

    int peek() {
        if (top == null) return -1;
        return top.data;
    }

    int getMin() {
        if (top == null) return -1; // Stack empty
        return top.min;
    }

    boolean isEmpty() {
        return top == null;
    }
}

public class MinStackExample {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(2);
        stack.push(10);
        stack.push(1);

        System.out.println("Minimum element: " + stack.getMin()); // 1

        stack.pop();
        System.out.println("Minimum after pop: " + stack.getMin()); // 2

        stack.pop();
        System.out.println("Minimum after another pop: " + stack.getMin()); // 2
    }
}