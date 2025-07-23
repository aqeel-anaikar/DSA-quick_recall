import java.util.Scanner;

class LinkedList {
    Node head; // head of the list
 
    // Node class
     class Node {
        int data;
        Node next;
 
        // constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
 
    // method to insert a node at the beginning of the linked list
    public void insertAtBeginning(int newData) {
        Node newNode = new Node(newData);
 
        // Make next of new node as head
        newNode.next = head;
 
        // Move the head to point to the new node
        head = newNode;
    }
 
    // method to insert a node at the end of the linked list
    public void insertAtEnd(int newData) {
        Node newNode = new Node(newData);
 
        // If the linked list is empty, then make the new node as head
        if (head == null) {
            head = new Node(newData);
            return;
        }
 
        // Traverse to the end of the linked list
        newNode.next = null;
 
        Node last = head;
        while (last.next != null)
            last = last.next;
 
        // Change the next of last node
        last.next = newNode;
        return;
    }
 
    // method to insert a node at a specified position
    public void insertAtPosition(int newData, int position) {
        Node newNode = new Node(newData);
        Node prev = null;
        Node current = head;
 
        int currentPosition = 0;
        while (currentPosition < position) {
            currentPosition++;
            prev = current;
            current = current.next;
        }
 
        // insert the new node at the specified position
        newNode.next = current;
        prev.next = newNode;
    }
    
    // method to delete a node at the beginning of the linked list
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
    }
    
    // method to delete a node at the end of the linked list
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node prev = null;
        Node current = head;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
    }
    
    // method to delete a node at a specified position
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node prev = null;
        Node current = head;
        int currentPosition = 0;
        while (currentPosition < position) {
            if (current == null) {
                System.out.println("The position is out of range.");
                return;
            }
            currentPosition++;
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
    }
 
    // method to print the linked list
    public void printList() {
        Node currentNode = head;
 
        System.out.print("LinkedList: ");
 
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
 // main method to test the LinkedList class
}

 public class LinkedListMain
 {
 public static void main(String[] args) {
    int a,pos;
    LinkedList linkedList = new LinkedList();
    Scanner sc = new Scanner(System.in);
    
    //Inserting
    //Insert At Beginning
    System.out.println("Insert At Beginning : Test Case");
    int test_case = sc.nextInt();
    System.out.println("Values :");
    // insert nodes at the beginning of the list
    for (int i = 0; i < test_case; i++) {
        a=sc.nextInt();
        linkedList.insertAtBeginning(a);
    }
    linkedList.printList();
    
    //Insert At End
    System.out.println("Insert At End : Test Case");
    test_case = sc.nextInt();
    System.out.println("Values :");
    // insert nodes at the end of the list
    for (int i = 0; i < test_case; i++) {
        a=sc.nextInt();
        linkedList.insertAtEnd(a);
    }
    linkedList.printList();
   
    //Insert At Position
    System.out.println("Insert At Position : Test Case");
    test_case = sc.nextInt();
    System.out.println("Values :");
    for (int i = 0; i < test_case; i++) {
        a=sc.nextInt();
        pos = sc.nextInt();
        linkedList.insertAtPosition(a, pos);
    }
    linkedList.printList();
    
    //Deleting
    //Delete At Beginning
    System.out.println("Delete At Beginning : Test Case");
    test_case = sc.nextInt();
    // Delete nodes at the beginning of the list
    for (int i = 0; i < test_case; i++) {
        linkedList.deleteAtBeginning();
    }
    linkedList.printList();
    
    //Delete At End
    System.out.println("Delete At End : Test Case");
    test_case = sc.nextInt();
    for (int i = 0; i < test_case; i++) {
        linkedList.deleteAtEnd();
    }
    linkedList.printList();
   
    
    //Delete At Position
    System.out.println("Delete At Position : Test Case");
    test_case = sc.nextInt();
    System.out.println("Values :");
    for (int i = 0; i < test_case; i++) {
        pos = sc.nextInt();
        linkedList.deleteAtPosition(pos);
    }
    linkedList.printList();

    
}
}