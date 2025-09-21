package Stacks_algorithm;

class Node {
    char data;
    Node next;
    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;

    void push(char ch) {
        Node newNode = new Node(ch);
        newNode.next = top;
        top = newNode;
    }

    char pop() {
        if (top == null) return '\0'; // Stack empty
        char ch = top.data;
        top = top.next;
        return ch;
    }

    boolean isEmpty() {
        return top == null;
    }
}

public class BalancedParenthesesUsingStackNode {

    public static boolean isBalanced(String expr) {
        Stack stack = new Stack();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;
                char topChar = stack.pop();
                if (!isMatchingPair(topChar, ch)) return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String expr1 = "{[()]}";
        String expr2 = "{[(])}";

        System.out.println(expr1 + " is balanced? " + isBalanced(expr1));  // true
        System.out.println(expr2 + " is balanced? " + isBalanced(expr2));  // false
    }
}

