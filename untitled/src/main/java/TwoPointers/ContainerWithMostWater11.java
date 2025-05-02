package TwoPointers;

public class ContainerWithMostWater11 {

    public int maxArea(int[] height) {

        int left =0;
        int right = height.length-1;
        int  max =0;

        while(left < right){

            int min = Math.min(height[left] , height[right]);
            int diff = right-left;

            int ans = min*diff;

            if(ans > max ){
                max = ans;
            }else if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return max;
    }
}
