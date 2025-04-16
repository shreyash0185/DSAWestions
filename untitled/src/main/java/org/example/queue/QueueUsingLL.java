package org.example.queue;

public class QueueUsingLL {
    public static void main(String[] args) {
        Queue q = new Queue();

        // Enqueue elements into the queue
        q.enqueue(10);
        q.enqueue(20);

        System.out.println("Queue Front: " + q.getFront());
        System.out.println("Queue Rear: " + q.getRear());

        // Dequeue elements from the queue
        q.dequeue();
        q.dequeue();

        // Enqueue more elements into the queue
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        // Dequeue an element from the queue
        q.dequeue();

        System.out.println("Queue Front: " + q.getFront());
        System.out.println("Queue Rear: " + q.getRear());
    }

}

class Node{
    int data ;
    Node next;

    Node(int new_data){
        this.data = new_data;
        this.next=null;
    }
}
// Class to implement queue operations using a linked list
class Queue{
// Pointer to the front and the rear of the linked list

    Node front , rear;

    // Constructor to initialize the front and rear
    Queue(){
        front = rear = null;

    }

    // Function to check if the queue is empty
    boolean isEmpty() {
        return front == null && rear == null;
    }

    // Function to add an element to the queue
    void enqueue(int new_data){

        Node new_node = new Node(new_data);

        if(rear == null){
            front = rear = new_node;
            return;
        }

        // Add the new node at the end of the queue and
        // change rear
        rear.next = new_node;
        rear = new_node;


    }

    // Function to remove an element from the queue
    void dequeue(){

        // If queue is empty, return
        if(isEmpty()){
            System.out.println("Queue Underflow");
            return;
        }

        // Store previous front and move front one node
        // ahead
        Node temp = front;
        front = front.next;

        // If front becomes null, then change rear also
        // to null
        if(front == null){
            rear = null;
        }
    }

    // Function to get the front element of the queue
    int getFront(){
        // Checking if the queue is empty
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return front.data;

    }

    // Function to get the rear element of the queue
    int getRear() {

        // Checking if the queue is empty
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return rear.data;
    }


}

//Time Complexity: O(1), The time complexity of both operations enqueue() and dequeue() is O(1) as it only changes a few pointers in both operations
//Auxiliary Space: O(1), The auxiliary Space of both operations enqueue() and dequeue() is O(1) as constant extra space is required