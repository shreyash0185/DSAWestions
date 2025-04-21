package DSAQestions.BinarySearch.BSOnAnswers;

public class findTheNthRootOfANumberUsingBinarySearch {

    public static int NthRoot(int n, int m) {
        // Write your code here.

        // Raand [1 ...... m]
        // 1 2 3  4 5 ......14.......... 27
        // 14*14*14 > 27

        // 1 2 3 4 5 6  7 ........ 13
        // 7*7*7 >27

        // 1 2 3 4 5 6
        // 3*3*3 == 27 return 3

        int low = 1 ;
        int high = m;

        while(low <= high){
            int mid = low + (high - low)/2;
            int midN = fun(mid , n, m);

            if((midN) == 1){
                return mid;
            }else if(midN ==0){
                low = mid+1;

            }else{
                high = mid-1;
            }
        }

        return -1;

    }

    public static int  fun(int mid , int n , int m){
        long ans = 1;
        for(int i=1;i<=n;i++){
            ans *=mid;

        }
        if(ans>m){
            return 2;
        }
        if(ans == m){
            return 1;
        }
        return 0;
    }

}
