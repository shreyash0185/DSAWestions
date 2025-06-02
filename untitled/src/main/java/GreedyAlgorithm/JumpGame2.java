package GreedyAlgorithm;

public class JumpGame2 {

    public int jump(int[] nums) {
        int jump=0;
        int l = 0 ;
        int r =0;

        while(r < nums.length-1){

            int farthest = 0;

            for(int idx = l ; idx<=r ;idx++){

                farthest = Math.max(farthest , idx + nums[idx]);


            }
            l = r+1;
            r = farthest;
            jump++;

        }

        return jump;

    }
}
