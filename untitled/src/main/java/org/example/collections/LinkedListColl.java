package org.example.collections;
// Java program to add elements to a LinkedList

import java.util.LinkedList;

public class LinkedListColl {

    // Main driver method
    public static void main(String[] args) {
        // Creating a LinkedList
        LinkedList<String> l = new LinkedList<String>();

        // Adding elements to the LinkedList using add() method
        l.add("One");
        l.add("Two");
        l.add("Three");
        l.add("Four");
        l.add("Five");

        // Printing the LinkedList
        System.out.println(l);

        l.set(1, "For");

        System.out.println(l);

        l.remove(1);

        System.out.println("After the Index Removal " + l);


        LinkedList<String> ll = new LinkedList<>();

        ll.add("Geeks");
        ll.add("Geeks");
        ll.add(1, "For");

        // Using the Get method and the
        // for loop
        for (int i = 0; i < ll.size(); i++) {
            System.out.print(ll.get(i) + " ");
        }

        System.out.println();

        // Using the for each loop
        for (String str : ll)
            System.out.print(str + " ");

    }


}


//Methods for Java LinkedList
//add(int index, E element)
//add(E e)
//addAll(int index, Collection<E> c)
//addAll(Collection<E> c)
//addLast(E e)
//addFirst(E e)
//clear()
//clone()
//contains(Object o)
//descendingIterator()
//element()
//get(int index)
//getFirst()
//getLast()
//indexOf(Object o)
//lastIndexOf(Object o)
//listIterator(int index)
//offer(E e)
//offerFirst(E e)
//offerLast(E e)	This method Inserts the specified element at the end of this list.
//peek()	This method retrieves but does not remove, the head (first element) of this list.
//peekFirst()	This method retrieves, but does not remove, the first element of this list, or returns null if this list is empty.
//peekLast()	This method retrieves, but does not remove, the last element of this list, or returns null if this list is empty.
//poll()	This method retrieves and removes the head (first element) of this list.
//pollFirst()
//pollLast()	This method retrieves and removes the last element of this list, or returns null if this list is empty.
//pop()	This method Pops an element from the stack represented by this list.
//push(E e)	This method pushes an element onto the stack represented by this list.
//remove()	This method retrieves and removes the head (first element) of this list.
//remove(int index)	This method removes the element at the specified position in this list.
//remove(Object o)
//removeFirst()	This method removes and returns the first element from this list.
//removeFirstOccurrence(Object o)	This method removes the first occurrence of the specified element in this list (when traversing the list from head to tail).
//removeLast()	This method removes and returns the last element from this list.
//removeLastOccurrence(Object o)	This method removes the last occurrence of the specified element in this list (when traversing the list from head to tail).
//set(int index, E element)	This method replaces the element at the specified position in this list with the specified element.
//size()
//spliterator()	This method creates a late-binding and fail-fast Spliterator over the elements in this list.
//toArray()	This method returns an array containing all of the elements in this list in proper sequence (from first to last element).
//toArray(T[] a)	This method returns an array containing all of the elements in this list in proper sequence (from first to last element); the runtime type of the returned array is that of the specified array.
//toString()

//Comparison with ArrayList
//Operation  	LinkedList  	ArrayList
//Insert at end 	O(1)    	O(1) (amortized)
//Insert at index	O(n)	    O(n) (due to shifting)
//Get element by index	O(n)    	O(1)
//Remove by index	O(n)    	O(n) (due to shifting)
//Remove first/last	O(1)    	O(n) (for first), O(1) (for last)