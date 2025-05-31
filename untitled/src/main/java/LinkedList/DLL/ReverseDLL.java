package LinkedList.DLL;



public class ReverseDLL {

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

    // Function to reverse a doubly linked list
  public static Node  reverseDLL(Node head) {
        Node current = head;
      Node newHead = null;

        // Traverse the list and swap next and prev pointers
        while (current != null) {
            Node temp = current.prev; // Store the previous node
            current.prev = current.next; // Swap next and prev pointers
            current.next = temp; // Set next to the stored previous node

            newHead = current;         // Track the last node processed (will become new head)
            current = current.prev;    // Move to next node (which is current.prev due to swap)

        }
        return newHead; // Return the new head of the reversed doubly linked list




    }

    // Function to print the doubly linked list
    public static void printDLL(Node head) {
        Node current = head; // Start from the head of the doubly linked list
        while (current != null) { // Traverse through the doubly linked list
            System.out.print(current.data + " "); // Print the data of the current node
            current = current.next; // Move to the next node
        }
        System.out.println(); // Print a new line after printing all elements
    }

    //main method to test the reverseDLL function
    public static void main(String[] args) {
        // Example usage
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;

        System.out.println("Original DLL:");
        printDLL(head);

//        reverseDLL(head);

        System.out.println("Reversed DLL:");
        printDLL(reverseDLL(head));
    }
}
