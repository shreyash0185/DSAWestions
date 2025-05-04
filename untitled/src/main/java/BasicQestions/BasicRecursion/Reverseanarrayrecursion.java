package BasicQestions.BasicRecursion;

public class Reverseanarrayrecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void reverseArray(int[] arr, int start, int end) {
       if(start >= end){
           return;
       }

       int temp = arr[start];
         arr[start] = arr[end];
         arr[end] = temp;

         reverseArray(arr, start + 1, end - 1);

    }

    // Another approach using a single parameter
    public static void reverseArray(int[] arr, int start) {

        if(start < arr.length / 2){

            // Swap the elements at start and end indices
            int temp = arr[start];
            arr[start] = arr[arr.length - start - 1];
            arr[arr.length - start - 1] = temp;
            reverseArray(arr, start + 1);
        }
    }
}
