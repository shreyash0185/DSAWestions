package LinkedList.SinglyLinkdList;

public class Add2numbersinLL {

    // Node class to represent each element in the linked list
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to add two numbers represented by linked lists
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node dummyHead = new Node(0); // Dummy node to simplify the addition process
        Node current = dummyHead; // Pointer to build the new linked list
        int carry = 0; // Variable to store carry during addition

        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry; // Start with the carry from the previous addition

            if (l1 != null) {
                sum += l1.data; // Add value from first list if available
                l1 = l1.next; // Move to the next node in first list
            }

            if (l2 != null) {
                sum += l2.data; // Add value from second list if available
                l2 = l2.next; // Move to the next node in second list
            }

            carry = sum / 10; // Calculate new carry for next iteration
            current.next = new Node(sum % 10); // Create a new node with the digit value
            current = current.next; // Move to the newly created node
        }

        return dummyHead.next; // Return the head of the new linked list, skipping the dummy node
    }
}
