package Queue_algorithm;

class Node {
    char data;
    Node next;
    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class CharQueue {
    Node front, rear;

    void enqueue(char ch) {
        Node node = new Node(ch);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    char dequeue() {
        if (front == null) return '\0';
        char ch = front.data;
        front = front.next;
        if (front == null) rear = null;
        return ch;
    }

    char peek() {
        if (front == null) return '\0';
        return front.data;
    }

    boolean isEmpty() {
        return front == null;
    }
}

public class FirstNonRepeatingCharacterStream {

    public static void processStream(String stream) {
        CharQueue queue = new CharQueue();
        int[] freq = new int[256]; // ASCII freq array

        for (int i = 0; i < stream.length(); i++) {
            char ch = stream.charAt(i);
            freq[ch]++;

            if (freq[ch] == 1) {
                queue.enqueue(ch);
            }

            // Remove all characters from front that are repeated
            while (!queue.isEmpty() && freq[queue.peek()] > 1) {
                queue.dequeue();
            }

            if (queue.isEmpty())
                System.out.print("# ");  // no non-repeating char
            else
                System.out.print(queue.peek() + " ");
        }
    }

    public static void main(String[] args) {
        String input = "aabbcddeef";
        System.out.println("Stream: " + input);
        System.out.print("First Non-Repeating Characters: ");
        processStream(input);
    }
}
