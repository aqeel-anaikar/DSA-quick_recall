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

    void push(int val) {
        Node newNode = new Node(val);
        newNode.next = top;
        top = newNode;
    }

    int pop() {
        if (top == null) return Integer.MIN_VALUE; // Stack empty
        int val = top.data;
        top = top.next;
        return val;
    }

    boolean isEmpty() {
        return top == null;
    }
}

public class PostfixCalculator {

    public static int evaluatePostfix(String expression) {
        Stack stack = new Stack();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isWhitespace(ch)) continue;

            if (Character.isDigit(ch)) {
                // For multi-digit numbers, parse the entire number
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                i--; // adjust because of extra increment in loop
                stack.push(num);
            } else {
                int val2 = stack.pop();
                int val1 = stack.pop();

                switch (ch) {
                    case '+': stack.push(val1 + val2); break;
                    case '-': stack.push(val1 - val2); break;
                    case '*': stack.push(val1 * val2); break;
                    case '/': stack.push(val1 / val2); break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String expr = "5 6 2 + * 12 4 / -";
        int result = evaluatePostfix(expr);
        System.out.println("Postfix Expression: " + expr);
        System.out.println("Evaluation Result: " + result);
    }
}