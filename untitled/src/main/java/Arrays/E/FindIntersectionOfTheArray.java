package Arrays.E;

public class FindIntersectionOfTheArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 6, 7, 8};
        int[] intersection = findIntersection(arr1, arr2);

        System.out.print("Intersection of the two arrays: ");
        for (int num : intersection) {
            System.out.print(num + " ");
        }
    }

    public static int[] findIntersection(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] result = new int[Math.min(n, m)];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr1[i] == arr2[j]) {
                    result[index++] = arr1[i];
                    break;
                }
            }
        }

        // Resize the result array to the actual number of intersections found
        int[] finalResult = new int[index];
        System.arraycopy(result, 0, finalResult, 0, index);

        return finalResult;
    }


    //Two Pointer approach
    public static int[] findIntersectionTwoPointer(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] result = new int[Math.min(n, m)];
        int index = 0;

        int i = 0, j = 0;
        while (i < n && j < m) {
            if (arr1[i] == arr2[j]) {
                result[index++] = arr1[i];
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // Resize the result array to the actual number of intersections found
        int[] finalResult = new int[index];
        System.arraycopy(result, 0, finalResult, 0, index);

        return finalResult;
    }
}
