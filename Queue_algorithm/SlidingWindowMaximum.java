package Queue_algorithm;

class Node {
    int index;
    Node next;
    Node prev;
    Node(int index) {
        this.index = index;
        this.next = null;
        this.prev = null;
    }
}

// Doubly linked deque implementation using nodes
class Deque {
    Node front, rear;

    boolean isEmpty() {
        return front == null;
    }

    void addLast(int index) {
        Node newNode = new Node(index);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
    }

    void removeLast() {
        if (isEmpty()) return;
        if (front == rear) {
            front = rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }
    }

    void removeFirst() {
        if (isEmpty()) return;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }
    }

    int getFirst() {
        if (front == null) return -1;
        return front.index;
    }

    int getLast() {
        if (rear == null) return -1;
        return rear.index;
    }
}

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque deque = new Deque();

        for (int i = 0; i < n; i++) {
            // Remove indexes out of bound (left side)
            if (!deque.isEmpty() && deque.getFirst() == i - k) {
                deque.removeFirst();
            }

            // Remove smaller elements from right
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }

            deque.addLast(i);

            // Record max for window starting at i-k+1
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] maxValues = maxSlidingWindow(arr, k);
        System.out.print("Sliding Window Maximums: ");
        for (int val : maxValues) {
            System.out.print(val + " ");
        }
    }
}