package Arrays.H;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int total = m + n;
        int gap = total / 2 + (total % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < total) {
                // Case 1: both indices in nums1
                if (left < m && right < m) {
                    SwapIfGreater(nums1, nums1, left, right);
                }
                // Case 2: left in nums1, right in nums2
                else if (left < m && right >= m) {
                    SwapIfGreater(nums1, nums2, left, right - m);
                }
                // Case 3: both in nums2
                else {
                    SwapIfGreater(nums2, nums2, left - m, right - m);
                }

                left++;
                right++;
            }

            if (gap == 1) break;
            gap = gap / 2 + (gap % 2);
        }

        // Copy sorted nums2 into nums1
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }

    public void SwapIfGreater(int[] arr1, int[] arr2, int i, int j) {
        if (arr1[i] > arr2[j]) {
            int temp = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = temp;
        }
    }
}
