package LinkedList.SinglyLinkdList;

public class PalindromeLinkedList {

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

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newH = reverse(slow.next);
        ListNode f = head;
        ListNode s = newH;

        while (s != null) {
            if (f.val != s.val) {
                return false;
            }
            f = f.next;
            s = s.next;
        }

        return true;


    }

    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode newH = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newH;

    }


}


