package LinkedList.SinglyLinkdList;

public class LengthofLoopinLL {

    // Node class to represent each element in the linked list
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to find the length of the loop in a linked list
    public static int lengthOfLoop(Node head) {
        if (head == null) return 0; // If the list is empty, return 0

        Node slow = head; // Slow pointer starts at the head
        Node fast = head; // Fast pointer also starts at the head

        // Detect loop using Floyd's Cycle-Finding Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one step
            fast = fast.next.next; // Move fast pointer by two steps

            if (slow == fast) { // Loop detected
                int loopLength = 1; // Initialize loop length
                Node current = slow;

                // Count the number of nodes in the loop
                while (current.next != slow) {
                    current = current.next;
                    loopLength++;
                }
                return loopLength; // Return the length of the loop
            }
        }
        return 0; // No loop found, return 0
    }
}
