package Arrays.E;

public class FindtheUnion {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 6, 7, 8};
        int[] union = findUnion(arr1, arr2);
        System.out.print("Union of the two arrays: ");
        for (int num : union) {
            System.out.print(num + " ");
        }
    }

    public static int[] findUnion(int[] arr1, int[] arr2) {
        int n = arr1.length + arr2.length;
        int[] union = new int[n];
        int index = 0;

        for (int num : arr1) {
            union[index++] = num;
        }
        for (int num : arr2) {
            boolean found = false;
            for (int i = 0; i < index; i++) {
                if (union[i] == num) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                union[index++] = num;
            }
        }

        // Resize the array to remove unused elements
        int[] result = new int[index];
        System.arraycopy(union, 0, result, 0, index);
        return result;
    }


    //Two pointer approach
    public static int[] findUnionTwoPointer(int[] arr1, int[] arr2) {
        int n = arr1.length + arr2.length;
        int[] union = new int[n];
        int index = 0;

        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                union[index++] = arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                union[index++] = arr2[j++];
            } else {
                union[index++] = arr1[i++];
                j++;
            }
        }

        while (i < arr1.length) {
            union[index++] = arr1[i++];
        }
        while (j < arr2.length) {
            union[index++] = arr2[j++];
        }

        // Resize the array to remove unused elements
        int[] result = new int[index];
        System.arraycopy(union, 0, result, 0, index);
        return result;
    }
}
