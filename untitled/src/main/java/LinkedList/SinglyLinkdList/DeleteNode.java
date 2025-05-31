package LinkedList.SinglyLinkdList;


public class DeleteNode {

    //Node class to represent each element in the linked list
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to delete a node from a singly linked list
    //Delete Head Node
    public static Node deleteHead(Node head) {
       if (head == null){  // Return the next node as the new head
         return null;
       }
         return head.next; // If the list is empty, return null
    }

    //Delete Tail Node
    public static void deleteTail(Node head){
        if(head == null || head.next == null){
            return; // If the list is empty or has only one node, do nothing
        }

        Node current = head;
        while(current.next.next !=null){
            current = current.next; // Traverse to the second last node
        }
        current.next = null; // Set the next of the second last node to null, effectively deleting the tail node

    }

    //Delete Node at a specific position
    public static void deleteAtPosition(Node head, int position){
        if(head == null || position<0){
            throw new IllegalArgumentException("Invalid position or empty list");
        }

        if(position == 0) {
            head = head.next; // If position is 0, delete the head node
            return;
        }

        Node current = head;
        for(int i = 0; i < position - 1 && current != null; i++) {
            current = current.next; // Traverse to the node before the desired position
        }
        if(current == null || current.next == null) {
            throw new IllegalArgumentException("Position out of bounds");
        }

        current.next = current.next.next; // Link the previous node to the node after the one to be deleted


    }

    //Delete Node by value
    public static Node deleteByValue(Node head , int value){
        if(head == null) {
            return null; // If the list is empty, return null
        }

        if (head.data == value){
            return head.next; // If the head node contains the value, return the next node as the new head
        }

        Node current = head;
        while(current.next != null && current.next.data != value) {
            current = current.next; // Traverse the list to find the node with the specified value
        }
        if(current.next == null) {
            return head; // If the value is not found, return the original head
        }
        current.next = current.next.next; // Link the previous node to the node after the one to be deleted
        return head; // Return the head of the list

    }

    // Function to print the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

//    Delete Node in a Linked List

//LeetCode 237. Delete Node in a Linked List
//There is a singly-linked list head and we want to delete a node node in it.
//
//You are given the node to be deleted node. You will not be given access to the first node of head.
//
//All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.

    public static void deleteNode(Node node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("Cannot delete the last node or a null node");
        }
        node.data = node.next.data; // Copy the data from the next node to the current node
        node.next = node.next.next; // Link the current node to the next of the next node
    }




}


