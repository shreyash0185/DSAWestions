package DSAQestions.BinarySearch.BSOn1DArray;

//Floor -> largest number of an array <= x

//Ceil -> smallest number in array >= x

public class FloorCeilInSortedArray {

    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        // Write your code here.
        int[] arr= new int[2];

        arr[0] = findFloor(a,  n,  x);
        arr[1] = findCeil(a,  n,  x);

        return arr;

    }

    public static int findFloor(int[] a, int n, int x){
        int low = 0;
        int high = n-1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(a[mid] <= x){
                ans = a[mid];
                low = mid +1;

            }else{
                high = mid -1;
            }
        }
        return ans;
    }
    public static int findCeil(int[] a, int n, int x){

        int low = 0;
        int high = n-1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(a[mid] >= x){
                high = mid -1;
                ans = a[mid];

            }else{
                low = mid +1;
            }
        }
        return ans;
    }
}
