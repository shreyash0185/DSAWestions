package LinkedList.DLL;

public class DeleteNodeInDLL {

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

  //Delete the Head Node
    public static Node deleteHead(Node head){
        if (head == null || head.next == null){
            return null; // If the list is empty or has only one node, return null
        }

        Node newHead = head.next; // Store the next node as the new head
        newHead.prev = null; // Set the previous pointer of the new head to null
        head.next = null; // Clear the next pointer of the old head
        return newHead; // Return the new head of the doubly linked list

    }

    //Delete the Tail Node

    public static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null; // If the list is empty or has only one node, return null
        }

        Node current = head;
        while (current.next != null) {
            current = current.next; // Traverse to the last node
        }

        current.prev.next = null; // Set the next pointer of the second last node to null
        current.prev = null; // Clear the previous pointer of the deleted tail node
        return head; // Return the head of the doubly linked list
    }

    //Delete Node at a specific position
    public static Node deleteAtPosition(Node head , int position){
        if(head == null || position <0){
            throw new IllegalArgumentException("Invalid position or empty list");
        }
        if(position == 0) {
            return deleteHead(head); // If position is 0, delete the head node
        }
        Node current = head;
        while (current != null && position > 0) {
            current = current.next; // Traverse to the node at the specified position
            position--;
        }
        if (current == null) {
            throw new IllegalArgumentException("Position out of bounds");
        }
        if (current.prev != null) {
            current.prev.next = current.next; // Link the previous node to the next node
        }
        if (current.next != null) {
            current.next.prev = current.prev; // Link the next node to the previous node
        }
        current.next = null; // Clear the next pointer of the deleted node
        current.prev = null; // Clear the previous pointer of the deleted node
        return head; // Return the head of the doubly linked list
    }

    //Delete Node by value
    public static Node deleteByValue(Node head, int value) {
        if (head == null) {
            return null; // If the list is empty, return null
        }

        Node current = head;
        while (current != null) {
            if (current.data == value) { // Check if the current node's data matches the value to be deleted
                if (current.prev != null) {
                    current.prev.next = current.next; // Link the previous node to the next node
                } else {
                    head = current.next; // If deleting the head, update the head pointer
                }
                if (current.next != null) {
                    current.next.prev = current.prev; // Link the next node to the previous node
                }
                current.next = null; // Clear the next pointer of the deleted node
                current.prev = null; // Clear the previous pointer of the deleted node
                return head; // Return the head of the doubly linked list
            }
            current = current.next; // Move to the next node
        }
        return head; // Return the head of the doubly linked list if value not found
    }



    //Main
    public static void main(String[] args) {
        // Example usage of the delete functions
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;

        // Deleting the head node
        head = deleteHead(head);

        // Deleting the tail node
        head = deleteTail(head);

        // Deleting a node at position 0
        head = deleteAtPosition(head, 0);

        // Print remaining nodes
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

}