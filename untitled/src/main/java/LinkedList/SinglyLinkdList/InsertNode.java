package LinkedList.SinglyLinkdList;

public class InsertNode {

    //Node class representing each element in the linked list
    public static class Node{
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    //Insert a node at the head of the linked list
    public static Node insertAtHead(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    //Insert a node at the tail of the linked list
    public static Node insertAtTail(Node head, int data) {
       Node newNode = new Node(data);
       if(head == null){
              return newNode; // If the list is empty, return the new node as the head
       }

         Node current = head;
       while(current.next != null){
              current = current.next; // Traverse to the end of the list
       }
         current.next = newNode; // Link the new node at the end
         return head; // Return the head of the list

    }

    //Insert a node at a specific position in the linked list
    public static Node insertAtPosition(Node head, int data, int position) {
    if (position < 0) {
        throw new IllegalArgumentException("Position cannot be negative");
    }
    Node newNode = new Node(data);
    if(position == 0){
        newNode.next = head;
        return newNode; // If position is 0, insert at head
    }

    Node current = head;
    while(current != null && position > 1) {
        current = current.next; // Traverse to the position before the desired position
        position--;
    }

    if (current == null) {
        throw new IllegalArgumentException("Position out of bounds");
    }
    newNode.next = current.next; // Link the new node to the next node
    current.next = newNode; // Link the previous node to the new node
    return head; // Return the head of the list
    }

    //Insert a node value at a specific position in the linked list
    public static Node insertValueAtPosition(Node head, int value, int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Position cannot be negative");
        }
        Node newNode = new Node(value);
        if (position == 0) {
            newNode.next = head;
            return newNode; // If position is 0, insert at head
        }

        Node current = head;
        while (current != null && position > 1) {
            current = current.next; // Traverse to the position before the desired position
            position--;
        }

        if (current == null) {
            throw new IllegalArgumentException("Position out of bounds");
        }
        newNode.next = current.next; // Link the new node to the next node
        current.next = newNode; // Link the previous node to the new node
        return head; // Return the head of the list
    }

    //Print the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = null;

        // Insert nodes at head
        head = insertAtHead(head, 10);
        head = insertAtHead(head, 20);
        head = insertAtHead(head, 30);
        printList(head); // Output: 30 -> 20 -> 10 -> null

        // Insert nodes at tail
        head = insertAtTail(head, 40);
        head = insertAtTail(head, 50);
        printList(head); // Output: 30 -> 20 -> 10 -> 40 -> 50 -> null

        // Insert node at specific position
        head = insertAtPosition(head, 25, 2);
        printList(head); // Output: 30 -> 20 -> 25 -> 10 -> 40 -> 50 -> null

        // Insert value at specific position
        head = insertValueAtPosition(head, 35, 3);
        printList(head); // Output: 30 -> 20 -> 25 -> 35 -> 10 -> 40 -> 50 -> null
    }


}
