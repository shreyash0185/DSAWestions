package LinkedList.DLL;

public class FindpairswithgivensuminDLL {

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

    public void findPairsWithSum(Node head, int targetSum) {
        if (head == null) return;

        Node left = head;
        Node right = head;

        // Move right pointer to the end of the list
        while (right.next != null) {
            right = right.next;
        }

        while (left != null && right != null && left != right && left.prev != right) {
            int currentSum = left.val + right.val;

            if (currentSum == targetSum) {
                System.out.println("Pair found: (" + left.val + ", " + right.val + ")");
                left = left.next; // Move left pointer forward
                right = right.prev; // Move right pointer backward
            } else if (currentSum < targetSum) {
                left = left.next; // Move left pointer forward
            } else {
                right = right.prev; // Move right pointer backward
            }
        }
    }
}
