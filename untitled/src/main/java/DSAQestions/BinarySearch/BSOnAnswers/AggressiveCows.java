package DSAQestions.BinarySearch.BSOnAnswers;

public class AggressiveCows {

    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        manualSort(stalls);
        int low = 1;
        int high = stalls[stalls.length-1] - stalls[0];

        while(low<=high){
            int mid = low + (high-low)/2;
            if(isPossible( stalls, mid, k)){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return high;
    }

    public static boolean isPossible(int[] stalls, int distance, int cows) {
        int count = 1;
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= distance) {
                count++;
                lastPosition = stalls[i];
            }
        }

        return count >= cows;



    }

    public static void manualSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    
}
