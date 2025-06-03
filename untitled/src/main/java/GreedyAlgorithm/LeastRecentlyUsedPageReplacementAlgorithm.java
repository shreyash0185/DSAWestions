package GreedyAlgorithm;

import java.util.LinkedList;
import java.util.List;

public class LeastRecentlyUsedPageReplacementAlgorithm {


    public class LRUPageReplacement {

        public static int LRU(int[] pages, int capacity) {
            List<Integer> memory = new LinkedList<>();
            int pageFaults = 0;

            for (int page : pages) {
                // Page not in memory => Page fault
                if (!memory.contains(page)) {
                    pageFaults++;
                    if (memory.size() == capacity) {
                        // Remove least recently used (first element)
                        memory.remove(0);
                    }
                    memory.add(page); // Add new page at end (most recently used)
                } else {
                    // Move the page to the end (mark as recently used)
                    memory.remove((Integer) page);
                    memory.add(page);
                }
                System.out.println("Page: " + page + " => Memory: " + memory);
            }

            System.out.println("\nTotal Page Faults: " + pageFaults);
            return pageFaults;
        }

        public static void main(String[] args) {
            int[] pages = {1, 2, 3, 4, 1, 2, 5};
            int capacity = 3;
            LRU(pages, capacity);
        }
    }


}
