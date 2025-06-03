package GreedyAlgorithm;

public class Minimumnumberofplatformsrequiredforarailway {

    //Brute Force Approach
    public int findPlatform(int arr[], int dep[], int n) {
        int maxPlatforms = 1; // At least one platform is needed
        for (int i = 0; i < n; i++) {
            int platformsNeeded = 1; // Start with one platform for the current train
            for (int j = 0; j < n; j++) {
                if (i != j && arr[i] <= dep[j] && dep[i] >= arr[j]) {
                    platformsNeeded++;
                }
            }
            maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
        }
        return maxPlatforms;
    }


    //Two Pointer Approach - with Sorting
    public int findPlatformTwoPointer(int arr[], int dep[], int n) {
        // Sort arrival and departure times
        java.util.Arrays.sort(arr);
        java.util.Arrays.sort(dep);

        int platformNeeded = 1; // At least one platform is needed
        int maxPlatforms = 1; // To keep track of the maximum platforms needed
        int i = 1, j = 0; // i for arrival, j for departure

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platformNeeded++;
                i++;
            } else {
                platformNeeded--;
                j++;
            }
            maxPlatforms = Math.max(maxPlatforms, platformNeeded);
        }

        return maxPlatforms;
    }
}
