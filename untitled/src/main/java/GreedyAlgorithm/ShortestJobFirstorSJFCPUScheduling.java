package GreedyAlgorithm;
import java.util.Arrays;

public class ShortestJobFirstorSJFCPUScheduling {

    //Return Average total time
    public double findAverageTime(int[] jobs) {
        int n = jobs.length;
       int wt =0;
       int t =0;
        Arrays.sort(jobs); // Sort jobs by their burst time

        for(int i = 0 ; i < n ; i++){
            wt += t; // Add waiting time of the current job
            t += jobs[i]; // Update total time with the burst time of the current job
        }
        return (double) wt / n; // Return average waiting time

    }

    //TC: O(n log n) for sorting + O(n) for calculating waiting time = O(n log n)


}
