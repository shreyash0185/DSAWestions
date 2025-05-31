package LinkedList.SinglyLinkdList;

public class MiddleofaLinkedList {

    // Node class to represent each element in the linked list
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to find the middle of a singly linked list
    public static Node findMiddle(Node head) {
        if (head == null) return null; // If the list is empty, return null

        Node slow = head; // Slow pointer starts at the head
        Node fast = head; // Fast pointer also starts at the head

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one step
            fast = fast.next.next; // Move fast pointer by two steps
        }

        return slow; // When fast reaches the end, slow will be at the middle
    }
}
