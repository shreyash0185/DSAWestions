package LinkedList.SinglyLinkdList;

import java.util.List;

public class FlatteningofLL {

    //Create a class for ListNode
    public static class ListNode {
        int val;
        ListNode next;
        ListNode child;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next, ListNode child) {
            this.val = val;
            this.next = next;
            this.child = child;
        }
    }

    public ListNode flatten(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mergeH = flatten(head.next);

        return merge(head, mergeH);


    }

    public ListNode merge(ListNode head, ListNode mergeH) {
        if (head == null) return mergeH;
        if (mergeH == null) return head;

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = mergeH;

        // Now we need to flatten the child nodes
        if (head.child != null) {
            ListNode childFlattened = flatten(head.child);
            head.child = null; // Clear the child pointer
            temp.next = childFlattened; // Append the flattened child list
        }

        return head;
    }


}
