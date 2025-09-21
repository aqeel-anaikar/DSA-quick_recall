package Stacks_algorithm;

import java.util.Stack;

public class InfixToPostfix {

    // Method to return precedence of operators
    public static int precedence(char ch) {
        switch (ch) {
            case '^': return 3; // Right associative (highest precedence)
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
            default: return -1;
        }
    }

    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // Skip spaces
            if (ch == ' ') continue;

            // If operand, add to output
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            // If '(', push to stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If ')', pop till '(' is found
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
            // Operator encountered
            else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    // Handle right-associativity for '^'
                    if (ch == '^' && stack.peek() == '^') break;
                    else result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') stack.pop();
            else result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String infixExp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix Expression: " + infixExp);
        String postfixExp = infixToPostfix(infixExp);
        System.out.println("Postfix Expression: " + postfixExp);
    }
}