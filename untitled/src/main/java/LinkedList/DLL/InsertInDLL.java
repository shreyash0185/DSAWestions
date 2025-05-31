package LinkedList.DLL;

public class InsertInDLL {
    // Node class to represent each element in the doubly linked list
    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Function to insert a new node at the end of the doubly linked list
    public static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode; // If the list is empty, return the new node as the head
        }

        Node current = head;
        while (current.next != null) {
            current = current.next; // Traverse to the last node
        }

        current.next = newNode; // Link the new node at the end
        newNode.prev = current; // Set the previous pointer of the new node
        return head; // Return the head of the list
    }

    // Function to insert a new node at the beginning of the doubly linked list
    public static Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode; // If the list is empty, return the new node as the head
        }

        newNode.next = head; // Link the new node to the current head
        head.prev = newNode; // Set the previous pointer of the current head
        return newNode; // Return the new node as the new head
    }

    // Function to insert a new node at a specific position in the doubly linked list
    public static Node insertAtPosition(Node head, int data, int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Position cannot be negative");
        }

        Node newNode = new Node(data);
        if (position == 0) {
            return insertAtBeginning(head, data); // If position is 0, insert at the beginning
        }

        Node current = head;
        while (current != null && position > 1) {
            current = current.next; // Traverse to the node before the desired position
            position--;
        }

        if (current == null) {
            throw new IllegalArgumentException("Position out of bounds");
        }

        newNode.next = current.next; // Link the new node to the next node
        if (current.next != null) {
            current.next.prev = newNode; // Set the previous pointer of the next node
        }
        current.next = newNode; // Link the previous node to the new node
        newNode.prev = current; // Set the previous pointer of the new node
        return head; // Return the head of the list
    }

    //Function to insert a new node at the end of the doubly linked list by value
    public static Node insertValueAtEnd(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            return newNode; // If the list is empty, return the new node as the head
        }

        Node current = head;
        while (current.next != null) {
            current = current.next; // Traverse to the last node
        }

        current.next = newNode; // Link the new node at the end
        newNode.prev = current; // Set the previous pointer of the new node
        return head; // Return the head of the list
    }




}
