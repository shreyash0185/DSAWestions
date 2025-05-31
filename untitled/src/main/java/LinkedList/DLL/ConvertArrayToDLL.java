package LinkedList.DLL;

public class ConvertArrayToDLL {

    //Convert array to doubly linked list

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

    public static Node convertArrayToDLL(int[] arr){
        if(arr == null || arr.length ==0){
            return null; // Return null if the array is empty or null
        }

        Node head = new Node(arr[0]); // Create the head node with the first element of the array
        Node current = head; // Initialize the current node to the head
        for(int i=1;i<arr.length;i++){
            Node newNode = new Node(arr[i]); // Create a new node for each element in the array
            current.next = newNode; // Link the current node to the new node
            newNode.prev = current; // Set the previous pointer of the new node to the current node
            current = newNode; // Move the current pointer to the new node
        }
        return head; // Return the head of the doubly linked list
    }

    // Function to print the doubly linked list
    public static void printDLL(Node head) {
        Node current = head; // Start from the head of the doubly linked list
        while (current != null) { // Traverse through the doubly linked list
            System.out.print(current.data + " "); // Print the data of the current node
            current = current.next; // Move to the next node
        }
        System.out.println(); // Print a new line after printing all elements
    }

    //Main
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Example array to convert to doubly linked list
        Node head = convertArrayToDLL(arr); // Convert the array to doubly linked list
        printDLL(head); // Print the doubly linked list
    }
}
