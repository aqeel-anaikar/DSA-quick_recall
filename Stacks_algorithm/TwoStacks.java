// Two Stacks in Single Array — Concept
// Use a single fixed-size array to hold two stacks. One stack grows from the start (left), and the other grows from the end (right) of the array. They grow toward each other, preventing overflow until the entire array is full.
package Stacks_algorithm;

public class TwoStacks {
    int[] arr;
    int size;
    int top1, top2;

    public TwoStacks(int n) {
        size = n;
        arr = new int[n];
        top1 = -1;
        top2 = size;
    }

    // Push in stack1
    public void push1(int x) {
        if (top1 < top2 - 1) {
            arr[++top1] = x;
        } else {
            System.out.println("Stack Overflow in Stack1");
        }
    }

    // Push in stack2
    public void push2(int x) {
        if (top1 < top2 - 1) {
            arr[--top2] = x;
        } else {
            System.out.println("Stack Overflow in Stack2");
        }
    }

    // Pop from stack1
    public int pop1() {
        if (top1 >= 0) {
            int val = arr[top1--];
            return val;
        } else {
            System.out.println("Stack Underflow in Stack1");
            return -1;
        }
    }

    // Pop from stack2
    public int pop2() {
        if (top2 < size) {
            int val = arr[top2++];
            return val;
        } else {
            System.out.println("Stack Underflow in Stack2");
            return -1;
        }
    }

    public static void main(String[] args) {
        TwoStacks stacks = new TwoStacks(10);

        stacks.push1(5);
        stacks.push2(10);
        stacks.push2(15);
        stacks.push1(11);
        stacks.push2(7);

        System.out.println("Popped from Stack1: " + stacks.pop1());
        System.out.println("Popped from Stack2: " + stacks.pop2());
    }
}