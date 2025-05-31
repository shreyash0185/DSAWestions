package LinkedList.SinglyLinkdList;

public class Add1toanumberrepresentedbyLL {

    // Node class to represent each element in the linked list
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to add 1 to a number represented by a singly linked list
    public static Node addOne(Node head) {
        head = reverse(head); // Reverse the linked list
        Node current = head;
        int carry = 1; // Start with carry of 1 for addition

        while (current != null && carry > 0) {
            int sum = current.data + carry; // Add carry to the current node's data
            current.data = sum % 10; // Update current node's data with the unit place
            carry = sum / 10; // Update carry for the next iteration
            if (current.next == null && carry > 0) { // If we reach the end and still have carry
                current.next = new Node(carry); // Create a new node for the carry
                carry = 0; // Reset carry
            }
            current = current.next; // Move to the next node
        }

        return reverse(head); // Reverse back to get the final result
    }

    // Helper function to reverse a linked list
    private static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next; // Store next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev to current
            current = nextNode; // Move to next node
        }
        return prev; // New head of the reversed list
    }


    //Approach 2 recursive approach

    public static Node addOneRecursive(Node head) {
        // Base case: if the list is empty, return a new node with value 1
        if (head == null) {
            return new Node(1);
        }

        int carry = 0;
        // Recursive call to the next node
        carry = helper(head);
        // If there's a carry left after processing all nodes, create a new node
        if (carry > 0) {
            Node newHead = new Node(carry);
            newHead.next = head; // Link the new node to the original head
            return newHead; // Return the new head
        }
        return head; // Return the original head if no carry left


    }

    // Helper function to recursively add 1 to the linked list
    private static int helper(Node node) {
        // Base case: if we reach the end of the list, return 1 (the carry)
        if (node == null) {
            return 1;
        }

        // Recursive call to the next node
        int carry = helper(node.next);

        // Add the carry to the current node's data
        int sum = node.data + carry;
        node.data = sum % 10; // Update current node's data with the unit place
        return sum / 10; // Return the carry for the next iteration
    }

}
