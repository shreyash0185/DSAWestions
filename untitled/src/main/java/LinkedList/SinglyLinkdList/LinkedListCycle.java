package LinkedList.SinglyLinkdList;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {

    //Using Hashing - O(n) time and O(n) space

    //Node class to represent each element in the linked list
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

     public boolean hasCycle(ListNode head) {
         Map<ListNode,Integer> map = new HashMap<>();

         ListNode temp = head;


         while(temp != null ){


             if (map.containsKey(temp)) {
                 return true;
             }else{
                 map.put(temp , 1);
             }
             temp = temp.next;
         }
         return false;
     }

     //Using Floyd's Cycle Detection Algorithm - O(n) time and O(1) space
        public boolean hasCycleFloyd(ListNode head) {
            if (head == null || head.next == null) {
                return false; // If the list is empty or has only one node, no cycle
            }

            ListNode slow = head; // Slow pointer starts at the head
            ListNode fast = head; // Fast pointer also starts at the head

            while (fast != null && fast.next != null) {
                slow = slow.next; // Move slow pointer by one step
                fast = fast.next.next; // Move fast pointer by two steps

                if (slow == fast) { // If they meet, there is a cycle
                    return true;
                }
            }
            return false; // If fast reaches the end, no cycle exists
        }


}
