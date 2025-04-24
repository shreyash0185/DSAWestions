package DSAQestions.BinarySearch.BSOnAnswers;

import java.util.Arrays;

public class capacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int days) {
        //Range -> [1  2  3  4 ....... sum (55)]

        // 1  2  3  4 ...28....  55

        // 1  2  3  4   14 ...28

        //  14 . . . 21 . ..28

        //  14 . . .17 . . . 21

        //   14 . 15. .17

        //   14 . 15.  -> mid 14 not possible > 5

        //   15

        int low = Arrays.stream(weights).max().getAsInt();
        int high = sum(weights);
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(weights, days, mid) <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;

    }

    public int isPossible(int[] weights, int days, int mid) {

        int sum = 0;
        int day = 1;

        for (int weight : weights) {
            if (sum + weight > mid) {
                day++;
                sum = 0;
            }

            sum += weight;
        }
        return day;
    }

    public int sum(int[] weights) {
        int ans = 0;
        for (int weight : weights) {
            ans += weight;
        }
        return ans;
    }

}
