package LinkedList.SinglyLinkdList;

//LeetCode 328: Odd Even Linked List
public class OddEvenLinkedList {

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

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next; // Link odd nodes
            even.next = even.next.next; // Link even nodes
            odd = odd.next; // Move to the next odd node
            even = even.next; // Move to the next even node
        }

        odd.next = evenHead; // Connect the end of odd list to the head of even list
        return head; // Return the modified list
    }
}
