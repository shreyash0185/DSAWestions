package TwoPointers.SlindingWindow;

public class BinarySubarraysWithSum930 {

    //Using Map
    // public int numSubarraysWithSum(int[] nums, int goal) {

    //     Map<Integer ,Integer> map = new HashMap<Integer,Integer>();
    //     int prefixSum =0;
    //     int count =0;
    //     map.put(0,1);

    //     for(int num : nums){

    //       prefixSum +=num;

    //       if(map.containsKey(prefixSum - goal)){
    //         count += map.get(prefixSum - goal);
    //       }

    //       map.put(prefixSum , map.getOrDefault(prefixSum , 0)+1);


    //     }

    //     return count;
    // }

    //Uising 2 P - SW

    public int numSubarraysWithSum(int[] nums, int goal) {

        return function(nums ,goal) - function(nums ,goal-1);


    }

    public int function(int[] nums, int goal){

        if (goal < 0) return 0;

        int l =0 , r =0;
        int sum =0;
        int count =0;


        while(r<nums.length){

            sum +=nums[r];

            while(sum > goal){
                sum -= nums[l];
                l++;
            }

            count += r-l+1;
            r++;
        }
        return count;
    }
}
