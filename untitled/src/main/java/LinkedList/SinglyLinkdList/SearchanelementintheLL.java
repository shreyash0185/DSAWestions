package LinkedList.SinglyLinkdList;

public class SearchanelementintheLL {

    // Node class to represent each element in the linked list
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to search for an element in a singly linked list
    public static boolean searchElement(Node head, int target) {
        Node current = head; // Start from the head of the linked list
        while (current != null) { // Traverse through the linked list
            if (current.data == target) { // Check if the current node's data matches the target
                return true; // Element found
            }
            current = current.next; // Move to the next node
        }
        return false; // Element not found in the linked list
    }
}
