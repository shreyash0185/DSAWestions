package Heap.medium;


//this qestion ca be solved with Priority Queue this is not efficient solution
//but the efficient approach is to use a map to store the ranks of the elements
public class Replaceeacharrayelementbyitscorrespondingrank {

//    efficient approach

    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
        java.util.Arrays.sort(sorted);

        java.util.Map<Integer, Integer> rankMap = new java.util.HashMap<>();
        int rank = 1;

        for (int num : sorted) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }

        return arr;
    }



    // Using Priority Queue (not efficient)
    public int[] arrayRankTransformUsingPQ(int[] arr) {
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();

        for (int num : arr) {
            pq.add(num);
        }

        java.util.Map<Integer, Integer> rankMap = new java.util.HashMap<>();
        int rank = 1;

        while (!pq.isEmpty()) {
            int num = pq.poll();
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }

        return arr;
    }

}


//📌 Summary
//Approach	Efficient	Intuitive	Time	Notes
//HashMap + Sort	✅ Yes	✅ Yes	O(n log n)	Best for this task
//PriorityQueue	❌ No	✅ Maybe	O(n log n)	Works, but less direct
//TreeMap	✅ Yes	✅ Yes	O(n log n)	Also good