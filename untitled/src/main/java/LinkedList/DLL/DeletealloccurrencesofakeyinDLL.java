package LinkedList.DLL;

public class DeletealloccurrencesofakeyinDLL {

    // Node class to represent each element in the doubly linked list
    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Function to delete all occurrences of a key in a doubly linked list
    public static Node deleteAllOccurrences(Node head, int key){
        if(head == null) {
            return null; // If the list is empty, return null
        }

        Node current = head;
        while (current != null){
            if(current.data == key){
                if(current == head){
                    head = current.next; // If the current node is the head, update the head
                }

                Node nextNode = current.next; // Store the next node
                Node prevNode = current.prev; // Store the previous node

                if(prevNode != null) {
                    prevNode.next = nextNode; // Link the previous node to the next node
                }

                if(nextNode != null) {
                    nextNode.prev = prevNode; // Link the next node to the previous node
                }

                current =current.next;
            }else{
                current = current.next; // Move to the next node if the current node is not the key
            }
        }
        return head; // Return the head of the modified doubly linked list
    }

    //Main method to test the deleteAllOccurrences function
    public static void main(String[] args) {
        // Create a sample doubly linked list: 1 <-> 2 <-> 3 <-> 2 <-> 4
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(2);
        Node fifth = new Node(4);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;
        fourth.next = fifth;
        fifth.prev = fourth;

        // Delete all occurrences of key 2
        head = deleteAllOccurrences(head, 2);

        // Print the modified list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

}
