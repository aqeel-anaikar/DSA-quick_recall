package Stacks_algorithm;

class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class Stack {
    Node top;

    void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    int pop() {
        if (top == null) return -1;
        int val = top.value;
        top = top.next;
        return val;
    }

    int peek() {
        if (top == null) return -1;
        return top.value;
    }

    boolean isEmpty() {
        return top == null;
    }
}

public class NextGreaterElement {

    public static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack stack = new Stack();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25, 7, 8};
        int[] nge = nextGreater(arr);

        System.out.println("Array: ");
        for (int num : arr) System.out.print(num + " ");
        System.out.println("\nNext Greater Elements: ");
        for (int val : nge) System.out.print(val + " ");
    }
}