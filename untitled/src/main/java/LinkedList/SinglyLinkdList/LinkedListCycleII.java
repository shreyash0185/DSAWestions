package LinkedList.SinglyLinkdList;

public class LinkedListCycleII {

    // Node class to represent each element in the linked list
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to detect the start of the cycle in a linked list
    public static Node detectCycle(Node head) {
        if (head == null || head.next == null) return null; // If the list is empty or has only one node

        Node slow = head; // Slow pointer starts at the head
        Node fast = head; // Fast pointer also starts at the head

        // Move slow by one step and fast by two steps
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one step
            fast = fast.next.next; // Move fast pointer by two steps

            if (slow == fast) { // Cycle detected
                Node entry = head; // Start from the head to find the entry point of the cycle
                while (entry != slow) { // Move both pointers until they meet
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry; // The node where the cycle begins
            }
        }
        return null; // No cycle detected
    }
}
