package Arrays.H;

public class MaximumProductSubarray {


    //Using N^2
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }


    //Using sufix and prefix veriable o(N)
    public int maxProduct1(int[] nums) {
        int p =1;
        int s =1;
        int ans = Integer.MIN_VALUE;


        for(int i=0;i<nums.length;i++){
            if(p == 0)p =1;
            if(s == 0)s =1;

            p = p*nums[i];
            s = s*nums[nums.length-i-1];

            ans = Math.max(ans , Math.max(p,s));
        }
        return ans;


    }

}
