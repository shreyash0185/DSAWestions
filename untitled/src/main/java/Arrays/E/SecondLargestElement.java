package Arrays.E;

//Second Largest Element in an Array without sorting
public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 2, 8};
        System.out.println("Second largest element in the array: " + findSecondLargest(arr));
    }

    public static int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }
}
