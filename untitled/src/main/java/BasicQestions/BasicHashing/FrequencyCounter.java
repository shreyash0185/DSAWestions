package BasicQestions.BasicHashing;

import java.util.Arrays;
import java.util.HashMap;

//Counting frequencies of array elements
public class FrequencyCounter {


    // Method to count frequencies of elements in an array
    public static void countFrequenciesWithArray(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] freq = new int[max + 1];  // size depends on max element

        for (int num : arr) {
            freq[num]++;
        }

        // Print frequencies
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.println("Element " + i + " occurs " + freq[i] + " times.");
            }
        }

    }


    // Method to count frequencies of elements in an array using HashMap

    public static void countFrequenciesWithMap(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);

        }

        for(int i : map.keySet()){
            System.out.println("Element " + i + " occurs " + map.get(i) + " times.");
        }
    }


}
