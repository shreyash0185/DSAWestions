package Arrays.H;

public class CountInversions {

    //merge sort based function to count inversions
    public int countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }
    private int mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return 0; // No inversions in a single element
        }

        int mid = left + (right - left) / 2;
        int count = 0;

        count += mergeSort(arr, left, mid);
        count += mergeSort(arr, mid + 1, right);
        count += merge(arr, left, mid, right);

        return count;
    }
    private int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int inversions = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversions += (mid - i + 1); // Count inversions
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }

        return inversions;
    }

}
