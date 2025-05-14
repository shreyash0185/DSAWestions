package Arrays.M;

public class RearrangeArrayElementsbySign {

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -4, 5, -6};
        rearrangeArray(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void rearrangeArray(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int posIndex = 0;
        int negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                result[posIndex] = arr[i];
                posIndex += 2;
            } else {
                result[negIndex] = arr[i];
                negIndex += 2;
            }
        }

        // Copy the rearranged array back to the original array
        System.arraycopy(result, 0, arr, 0, n);
    }

    //If the number of +ve and -ve are not same then
    //the remaining elements will be at the end of the array
    public int[] rearrangeArray1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int posIndex = 0;
        int negIndex = 1;

        for (int num : nums) {
            if (num >= 0) {
                // Only assign if within bounds
                if (posIndex < n) {
                    result[posIndex] = num;
                    posIndex += 2;
                }
            } else {
                if (negIndex < n) {
                    result[negIndex] = num;
                    negIndex += 2;
                }
            }
        }

        // If either index overflowed before others were exhausted, fill remaining
        for (int num : nums) {
            if (num >= 0 && posIndex < n) {
                result[posIndex] = num;
                posIndex++;
            } else if (num < 0 && negIndex < n) {
                result[negIndex] = num;
                negIndex++;
            }
        }

        return result;
    }
}


// This code rearranges the elements of an array such that positive and negative numbers are alternated.
