package LinkedList.SinglyLinkdList;

public class RotateList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k ==0)return head;

        int len =1;
        ListNode tail = head;
        while(tail.next != null){
            len++;
            tail = tail.next;

        }

        if(k%len ==0 )return head;

        k = k%len;
        ListNode kthNode = findKth(head , len-k);

        tail.next = head;
        ListNode newH = kthNode.next;
        kthNode.next = null;

        return newH;

    }
    public ListNode findKth(ListNode head, int k) {
        ListNode temp = head;

        while(temp!= null && --k > 0){
            temp = temp.next;
        }
        return temp;
    }

}
