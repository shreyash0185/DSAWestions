package LinkedList.SinglyLinkdList;

public class DeletetheMiddleNodeofaLinkedList {


     public class ListNode {
         int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }



        public ListNode deleteMiddle(ListNode head) {
            if(head.next == null)return null;
            ListNode slow = head;
            ListNode slow2 = head;
            ListNode fast = head;

            while(fast != null && fast.next !=null){
                slow2 = slow;
                slow = slow.next;
                fast = fast.next.next;

            }
            slow2.next =slow.next;

            return head;
        }

        // public ListNode deleteMiddle(ListNode head) {
        //     if(head.next == null)return null;
        //    ListNode temp = head;
        //    int n =0;
        //    while(temp!=null){
        //         temp = temp.next ;
        //         n++;
        //    }

        //    int nn = n/2;
        //    temp = head;
        //  for(int i =0;i<nn-1;i++){
        //     temp = temp.next;
        //  }
        //         temp.next = temp.next.next;
        //  return head;


        // }
         }

}
