package LinkedList.SinglyLinkdList;

public class SortLL012 {

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

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode zeroHead = new ListNode(0);
        ListNode oneHead = new ListNode(0);
        ListNode twoHead = new ListNode(0);

        ListNode zeroTail = zeroHead;
        ListNode oneTail = oneHead;
        ListNode twoTail = twoHead;

        while (head != null) {
            if (head.val == 0) {
                zeroTail.next = head;
                zeroTail = zeroTail.next;
            } else if (head.val == 1) {
                oneTail.next = head;
                oneTail = oneTail.next;
            } else {
                twoTail.next = head;
                twoTail = twoTail.next;
            }
            head = head.next;
        }

        // Connect the three lists
        zeroTail.next = oneHead.next; // Skip dummy node
        oneTail.next = twoHead.next; // Skip dummy node
        twoTail.next = null; // End the list

        return zeroHead.next; // Skip dummy node
    }
}
