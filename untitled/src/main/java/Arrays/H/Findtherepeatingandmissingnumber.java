package Arrays.H;

public class Findtherepeatingandmissingnumber {

    //Brute Force O(N^2)
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    ans[0] = nums[i]; // Repeating number
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                ans[1] = i; // Missing number
                break;
            }
        }

        return ans;
    }


    //Using hashmap O(N)
    public int[] findErrorNums1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 1; i <= n; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) > 1) {
                    ans[0] = i; // Repeating number
                }
            } else {
                ans[1] = i; // Missing number
            }
        }

        return ans;
    }


    //Using Frequency Array O(N)
    public int[] findErrorNums2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        int[] freq = new int[n + 1];

        for (int num : nums) {
            freq[num]++;
        }

        for (int i = 1; i <= n; i++) {
            if (freq[i] == 2) {
                ans[0] = i; // Repeating number
            } else if (freq[i] == 0) {
                ans[1] = i; // Missing number
            }
        }

        return ans;
    }

    //Using basic Maths - O(N)
    public int[] findErrorNums4(int[] nums) {

         long n = nums.length;

        //S - Sn = X - Y
        // S2 - S2n = X^2 - Y^2

         long Sn = n * (n + 1) / 2;
         long S2n = n * (n + 1) * (2 * n + 1) / 6;
         long S = 0, S2 = 0;
        for (int num : nums) {
            S += num;
            S2 += num * num;
        }
         long XminusY = S - Sn; // X - Y
         long X2minusY2 = S2 - S2n; // X^2 - Y^2
         long XplusY = X2minusY2 / XminusY; // X + Y
         long X = (XminusY + XplusY) / 2; // X
        long Y = X - XminusY; // Y
        return new int[]{(int) X, (int) Y}; // Return as int array

    }


    //Using XOR - O(N)
    public int[] findErrorNums3(int[] nums) {

        long n = nums.length;
        int xor = 0;
       for(int i=0;i<n;i++){
           xor = xor ^ nums[i] ^ (i + 1);
       }
       int bitNo =0;
       while(true){
           if((xor & (1 << bitNo))!= 0){
                break;
           }
              bitNo++;
       }

       //bitNo = 2 as we found in test case

        int zero  =0;
       int one=0 ;

       for (int i = 1; i <= n; i++) {
           if ((nums[i] & (1 << bitNo)) != 0) {
               one = one ^ i;
           } else {
               zero = zero ^i;
           }
       }





       return new int[]{zero, one}; // Return as int array

    }


}
