// Stock Span Problem — Concept
// For a series of daily stock prices, the stock span of a day is the number of consecutive previous days for which the price was less than or equal to the price on that day. It helps analyze stock performance and trading patterns.

package Stacks_algorithm;

class Node {
    int price;
    int index;
    Node next;
    Node(int price, int index) {
        this.price = price;
        this.index = index;
        this.next = null;
    }
}

class Stack {
    Node top;

    void push(int price, int index) {
        Node newNode = new Node(price, index);
        newNode.next = top;
        top = newNode;
    }

    Node pop() {
        if (top == null) return null;
        Node temp = top;
        top = top.next;
        return temp;
    }

    Node peek() {
        return top;
    }

    boolean isEmpty() {
        return top == null;
    }
}

public class StockSpan {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack stack = new Stack();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek().price <= prices[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek().index);
            stack.push(prices[i], i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);

        System.out.println("Prices: ");
        for (int price : prices) System.out.print(price + " ");
        System.out.println("\nSpan: ");
        for (int s : span) System.out.print(s + " ");
    }
}

