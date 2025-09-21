package Queue_algorithm;

class Node {
    int pid;         // process/job id
    int burstTime;   // remaining burst time
    Node next;

    public Node(int pid, int burstTime) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.next = null;
    }
}

class Queue {
    Node front, rear;
    int size;

    public Queue() {
        front = rear = null;
        size = 0;
    }

    void enqueue(int pid, int burstTime) {
        Node node = new Node(pid, burstTime);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    Node dequeue() {
        if (front == null) return null;
        Node temp = front;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return temp;
    }

    boolean isEmpty() {
        return size == 0;
    }
}

public class MultiLevelFeedbackQueue {

    private Queue[] queues;
    private int[] timeQuanta;
    private int levels;

    public MultiLevelFeedbackQueue(int levels, int[] timeQuanta) {
        this.levels = levels;
        this.timeQuanta = timeQuanta;
        queues = new Queue[levels];
        for (int i = 0; i < levels; i++) {
            queues[i] = new Queue();
        }
    }

    public void addJob(int pid, int burstTime) {
        // All new jobs enter highest priority queue (index 0)
        queues[0].enqueue(pid, burstTime);
        System.out.println("Added Job " + pid + " with burst time " + burstTime + " to queue 0");
    }

    public void schedule() {
        System.out.println("\nStarting Multi-level Feedback Queue Scheduling");

        while (true) {
            boolean allEmpty = true;
            for (int i = 0; i < levels; i++) {
                if (!queues[i].isEmpty()) {
                    allEmpty = false;
                    Node job = queues[i].dequeue();

                    int quantum = timeQuanta[i];
                    int executionTime = Math.min(job.burstTime, quantum);

                    System.out.println("Running Job " + job.pid + " from Queue " + i + 
                                       " for " + executionTime + " units");
                    job.burstTime -= executionTime;

                    if (job.burstTime > 0) {
                        // Demote to next lower priority if not already lowest
                        int nextLevel = (i == levels - 1) ? i : i + 1;
                        queues[nextLevel].enqueue(job.pid, job.burstTime);
                        System.out.println("Job " + job.pid + " moved to Queue " + nextLevel +
                                           " with burst time " + job.burstTime);
                    } else {
                        System.out.println("Job " + job.pid + " finished execution");
                    }
                    break; // Run one job at a time (simulate CPU)
                }
            }
            if (allEmpty) {
                System.out.println("All jobs completed.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        int levels = 3;
        int[] timeQuanta = {4, 8, 12}; // example time quanta for queues 0,1,2

        MultiLevelFeedbackQueue mlfq = new MultiLevelFeedbackQueue(levels, timeQuanta);

        // Add sample jobs (pid, burstTime)
        mlfq.addJob(1, 10);
        mlfq.addJob(2, 6);
        mlfq.addJob(3, 14);
        mlfq.addJob(4, 4);

        mlfq.schedule();
    }
}