package DSAQestions.BinarySearch.BSOnAnswers;

import java.util.ArrayList;

public class PaintersPartitionProblem {

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        if(k> boards.size()){
            return -1;
        }
        int low = max(boards);
        int high = sum(boards);

        while(low <= high ){

            int mid = low +(high-low)/2;

            if(check(boards,mid) > k){
                low = mid +1;
            }else{
                high = mid-1;
            }
        }

        return low;
    }
    public static int check(ArrayList<Integer> nums, int mid){
        int student=1;
        int noOfBook = 0;

        for(int num : nums){
            if(noOfBook + num <= mid){
                noOfBook +=num;
            }else{
                student++;
                noOfBook = num;
            }
        }
        return student;
    }


    public static int max(ArrayList<Integer>  nums){
        int max =-1;
        for(int num : nums){
            if(num > max){
                max =num;
            }
        }
        return max;
    }

    public static  int sum(ArrayList<Integer> nums){
        int ans  = 0;
        for(int num : nums){
            ans +=num;
        }
        return ans;

    }



}
