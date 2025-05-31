package LinkedList.SinglyLinkdList;

public class FindtheLengthofthelinkedlist {

    //Node class to represent each element in the linked list
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to find the length of a singly linked list
    public static int findLength(Node node){
        int length=0;
        while(node != null){
            length++; // Increment the length for each node
            node = node.next; // Move to the next node
        }
        return length; // Return the total length of the linked list

    }
}
