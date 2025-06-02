package LinkedList.DLL;

public class RemoveduplicatesfromsortedDLL {

    // Definition for doubly-linked list.
    public static class Node {
        int val;
        Node next;
        Node prev;

        Node() {}

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public Node removeDuplicates(Node head) {
        if (head == null) return null; // If the list is empty, return null

        Node current = head;

        while (current!=null && current.next != null){
            Node nextNode = current.next;

            while (nextNode != null && nextNode.val == current.val) {
                // Skip the duplicate node
                nextNode = nextNode.next;
            }
            // Link the current node to the next unique node
            current.next = nextNode;
            if (nextNode != null) {
                nextNode.prev = current; // Update the previous pointer of the next unique node
            }
            current = nextNode; // Move to the next unique node

        }
        return head; // Return the head of the modified doubly linked list
    }
}
