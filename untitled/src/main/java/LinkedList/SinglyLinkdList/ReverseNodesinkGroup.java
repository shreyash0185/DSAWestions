package LinkedList.SinglyLinkdList;

public class ReverseNodesinkGroup {

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

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){

            ListNode KthNode = getKthNode(temp , k);

            if(KthNode == null){
                prev.next = temp;
                break;
            }


            ListNode newN = KthNode.next;
            KthNode.next = null;
            reverse(temp);
            if(temp == head){
                head = KthNode;
            }else{
                prev.next = KthNode;
            }
            prev = temp;
            temp = newN;


        }
        return head;
    }

    public ListNode getKthNode(ListNode head, int k) {
        ListNode temp = head;
        while (temp != null && --k > 0) {
            temp = temp.next;
        }
        return temp;
    }

    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode nextN = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextN;
        }
        return prev;

    }
}
