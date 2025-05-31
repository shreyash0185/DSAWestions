package CollectionsJava;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        // This is a placeholder for the main method.
        // You can add code here to test collections in Java.
        System.out.println("Collection Test is running.");

        OurGenericList<Integer> integerList = new OurGenericList<>();

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        //we have to user Iterator to iterate over the list
        Iterator<Integer> iterator = integerList.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println("Value: " + value);
        }

        //same can be done using for-each loop
        for(int x : integerList) {
            System.out.println("Value using for-each: " + x);
        }





        //******************************************************************************************************

//        List -> way to impl List -> ArrayList ,, LinkdList , Vector

//        1.ArrayList
        List<Integer> arrayList = new java.util.ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);


        //Iterator for ArrayList
        Iterator<Integer> arrayListIterator = arrayList.iterator();
        arrayListIterator.next();
//        arrayListIterator.previous(); // This will throw an exception as ArrayList iterator does not support previous() method
        //On Lindlist, it will work as it supports bidirectional iteration


        while (arrayListIterator.hasNext()) {
            Integer value = arrayListIterator.next();
            System.out.println("Value from ArrayList: " + value);
        }


        System.out.println("ArrayList: " + arrayList);

        // 2. LinkedList  -> linkdlist als implement deque interface, so it can be used as a queue or stack
        List<Integer> linkedList = new java.util.LinkedList<>();
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);

        List<Integer> linkedList2 = new java.util.LinkedList<>();
        linkedList2.add(10);
        linkedList2.add(11);

        linkedList2.addAll(linkedList); // Adding all elements from linkedList to linkedList2
        linkedList2.indexOf(10); // Returns the index of the first occurrence of 10
        linkedList2.lastIndexOf(10); // Returns the index of the last occurrence of 10

        List<Integer> subList = linkedList2.subList(0, 2); // Returns a view of the portion of the list between the specified fromIndex, inclusive, and toIndex, exclusive
        subList.set(0, 100); // Sets the element at index 0 to 100 in the sublist

        //Sublist will reflect the changes in the original list

        System.out.println("LinkedList: " + linkedList);


        // 3. Vector
        List<Integer> vector = new Vector<>();
        vector.add(7);
        vector.add(8);
        vector.add(9);

        System.out.println("Vector: " + vector);

        // Iterating through the collections
        System.out.println("Iterating through ArrayList:");
        for (Integer num : arrayList) {
            System.out.println(num);
        }

        System.out.println("Iterating through LinkedList:");

        for (Integer num : linkedList) {
            System.out.println(num);
        }

        System.out.println("Iterating through Vector:");

        for (Integer num : vector) {
            System.out.println(num);
        }

//       ******************************************************************************************************
            // In java wedont have Queue class we have interface which is implemented by LinkedList and PriorityQueue or ArrayDeque'

        // 4. Queue using LinkedList
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new ArrayDeque<>();
        queue.offer(1); // Add to the end of the queue
        queue.offer(2);
        queue.offer(3);
        queue.poll();
        queue.peek(); // Get the head of the queue without removing it

        System.out.println("Queue using LinkedList: " + queue);

        // Iterating through the queue
        System.out.println("Iterating through Queue:");
        for (Integer num : queue) {
            System.out.println(num);
        }
        // Deque using ArrayDeque
        Deque<Integer> deque = new ArrayDeque<>();


        //**********************************************************************************************


        //Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(1); // Add to the top of the stack
        stack.push(2);
        stack.push(3);
        stack.pop(); // Remove the top element
        stack.peek(); // Get the top element without removing it
        System.out.println("Stack: " + stack);
        // Iterating through the stack
        System.out.println("Iterating through Stack:");
        for (Integer num : stack) {
            System.out.println(num);
        }

        //**********************************************************************************************

        //PriorityQueue

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(3); // Add to the queue
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        System.out.println("PriorityQueue: " + priorityQueue);
        // Iterating through the priority queue
        System.out.println("Iterating through PriorityQueue:");
        for (Integer num : priorityQueue) {
            System.out.println(num);
        }


        //**********************************************************************************************

        //Comparators and Comparables for priority queue

        //Comparable Interface is used to define the natural ordering of objects at class level.
        class Person implements Comparable<Person> {
            String name;
            int age;

            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public int compareTo(Person other) {
                return Integer.compare(this.age, other.age); // Compare by age
            }

            @Override
            public String toString() {
                return "Person{name='" + name + "', age=" + age + '}';
            }
        }

        //Using Comparable
        PriorityQueue<Person> personQueue = new PriorityQueue<>();
        personQueue.offer(new Person("Alice", 30));
        personQueue.offer(new Person("Bob", 25));
        personQueue.offer(new Person("Charlie", 35));
        System.out.println("PriorityQueue with Comparable:");
        while (!personQueue.isEmpty()) {
            System.out.println(personQueue.poll()); // Poll will return the person with the smallest age
        }


        //Using Comparator
        class PersonComparator implements Comparator<Person> {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.age, p2.age); // Compare by age
            }
        }
        PriorityQueue<Person> personQueueWithComparator = new PriorityQueue<>(new PersonComparator());
        personQueueWithComparator.offer(new Person("Alice", 30));
        personQueueWithComparator.offer(new Person("Bob", 25));
        personQueueWithComparator.offer(new Person("Charlie", 35));
        System.out.println("PriorityQueue with Comparator:");
        while (!personQueueWithComparator.isEmpty()) {
            System.out.println(personQueueWithComparator.poll()); // Poll will return the person with the smallest age
        }

        //**********************************************************************************************

        //Set -> way to impl Set -> HashSet , LinkedHashSet , TreeSet

        // 1 . HashSet
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);

        hashSet.add(1); // Duplicate element, will not be added

        System.out.println("HashSet: " + hashSet);
        // Iterating through the HashSet
        System.out.println("Iterating through HashSet:");
        for (Integer num : hashSet) {
            System.out.println(num);
        }

        // 2. LinkedHashSet is also a hash set but it maintains the insertion order

        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(4);
        linkedHashSet.add(5);
        linkedHashSet.add(6);
        linkedHashSet.add(4); // Duplicate element, will not be added
        System.out.println("LinkedHashSet: " + linkedHashSet);
        // Iterating through the LinkedHashSet
        System.out.println("Iterating through LinkedHashSet:");
        for (Integer num : linkedHashSet) {
            System.out.println(num);
        }

        //linkedHashset on custom class student
        class Student {
            String name;
            int age;

            Student(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return "Student{name='" + name + "', age=" + age + '}';
            }
        }

        Set<Student> studentSet = new LinkedHashSet<>();

        //need to override equals and hashCode methods in Student class for proper functioning of LinkedHashSet
        studentSet.add(new Student("Alice", 20));
        studentSet.add(new Student("Bob", 22));
        studentSet.add(new Student("Alice", 20)); // Duplicate element, will not be added
        System.out.println("LinkedHashSet with Student objects: " + studentSet);

        //implementing equals and hashCode in Student class
        class StudentWithEquals {
            String name;
            int age;

            StudentWithEquals(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof StudentWithEquals)) return false;
                StudentWithEquals that = (StudentWithEquals) o;
                return age == that.age && Objects.equals(name, that.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, age);
            }

            @Override
            public String toString() {
                return "Student{name='" + name + "', age=" + age + '}';
            }
        }

        Set<StudentWithEquals> studentSetWithEquals = new LinkedHashSet<>();
        studentSetWithEquals.add(new StudentWithEquals("Alice", 20));
        studentSetWithEquals.add(new StudentWithEquals("Bob", 22));
        studentSetWithEquals.add(new StudentWithEquals("Alice", 20)); // Duplicate element, will not be added
        System.out.println("LinkedHashSet with Student objects with equals and hashCode: " + studentSetWithEquals);



        //Sorted Set - done by balanced binary search tree, it stores elements in sorted order


        // 3. TreeSet  is it sorted set, it stores elements in sorted order
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(7);
        treeSet.add(8);
        treeSet.add(9);
        treeSet.add(7); // Duplicate element, will not be added
        System.out.println("TreeSet: " + treeSet);
        // Iterating through the TreeSet
        System.out.println("Iterating through TreeSet:");
        for (Integer num : treeSet) {
            System.out.println(num);
        }
        //**********************************************************************************************
    //map - implemented by HashMap, LinkedHashMap, TreeMap

        // 1. HashMap
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        hashMap.put(1, "One"); // Duplicate key, will overwrite the value

        System.out.println("HashMap: " + hashMap);
        // Iterating through the HashMap
        System.out.println("Iterating through HashMap:");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 2. LinkedHashMap
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(4, "Four");
        linkedHashMap.put(5, "Five");
        linkedHashMap.put(6, "Six");
        linkedHashMap.put(4, "Four"); // Duplicate key, will overwrite the value

        System.out.println("LinkedHashMap: " + linkedHashMap);
        // Iterating through the LinkedHashMap
        System.out.println("Iterating through LinkedHashMap:");
        for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 3. TreeMap
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(7, "Seven");
        treeMap.put(8, "Eight");
        treeMap.put(9, "Nine");
        treeMap.put(7, "Seven"); // Duplicate key, will overwrite the value

        System.out.println("TreeMap: " + treeMap);
        // Iterating through the TreeMap
        System.out.println("Iterating through TreeMap:");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }




    }
}
