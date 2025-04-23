package DSAQestions.BinarySearch.BSOnAnswers;

import java.util.ArrayList;

public class AllocateBooks {

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.

        if(m>arr.size()){
            return -1;
        }
        int low = max(arr);
        int high = sum(arr);

        while(low<=high){

            int mid = low + (high-low)/2;

            if(check(arr,mid)>m){

                low = mid+1;

            }else{
                high = mid-1;
            }
        }

        return low;
    }

    public static int check(ArrayList<Integer> arr,  int mid){
        int countOfStudent = 1;
        long pageOfStudent = 0;

        for(int num : arr){
            if(pageOfStudent + num <= mid){
                pageOfStudent += num;

            }else{
                countOfStudent +=1;
                pageOfStudent = num;
            }

        }
        return countOfStudent;
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
