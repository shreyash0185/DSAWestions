package LinkedList.SinglyLinkdList;

public class removeNthFromEnd {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //time complexity: O(L) where L is the length of the linked list  - 2 passs
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;
        ListNode temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;

        }

        int x = cnt - n;
        // Special case: removing the head
        if (x == 0) {
            return head.next;
        }

        temp = head;
        while (x > 1) {
            temp = temp.next;
            x--;
        }

        // Remove the target node
        temp.next = temp.next.next;

        return head;

    }

    //time complexity: O(L) where L is the length of the linked list  - 1 pass

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) return head.next; // Remove the first node

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next; // Remove the nth node from the end
        return head;
    }
}
