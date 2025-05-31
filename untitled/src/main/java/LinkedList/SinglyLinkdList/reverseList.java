package LinkedList.SinglyLinkdList;

public class reverseList {

    // Node class to represent each element in the linked list
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to reverse a singly linked list iteratively
    public static Node reverseList(Node head) {
        Node prev = null; // Previous node starts as null
        Node current = head; // Start with the head of the linked list

        while (current != null) { // Traverse through the linked list
            Node nextNode = current.next; // Store the next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev to current
            current = nextNode; // Move to the next node
        }
        return prev; // New head of the reversed linked list
    }

    // Recursive function to reverse a singly linked list
    public static Node reverseListRecursive(Node head) {
        if (head == null || head.next == null) { // Base case: if list is empty or has one node
            return head; // Return the head as the new head
        }
        Node newHead = reverseListRecursive(head.next); // Recursively reverse the rest of the list
        Node front = head.next;
        front.next = head;
        head.next =null;
        return newHead;
    }
}
