package GreedyAlgorithm;

public class Candy {
    //Approach 1 with TC- 3 * O(n) and SC- 2 * O(n)
    public int candy1(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;

        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];

        // Initialize both arrays with 1
        for (int i = 0; i < n; i++) {
            leftToRight[i] = 1;
            rightToLeft[i] = 1;
        }

        // Left to Right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftToRight[i] = leftToRight[i - 1] + 1;
            }
        }

        // Right to Left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightToLeft[i] = rightToLeft[i + 1] + 1;
            }
        }

        // Calculate the total candies needed
        int totalCandies = 0;
        for (int i = 0; i < n; i++) {
            totalCandies += Math.max(leftToRight[i], rightToLeft[i]);
        }

        return totalCandies;
    }


    //Approach 2 with TC- 2* O(n) and SC- O(N) without rightToLeft array
    public int candyOptimized(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;

        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = 1; // Initialize each child with one candy
        }

        // Left to Right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to Left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Calculate the total candies needed
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }

    //Approach 3 with TC- O(n) and SC- O(1) without any extra space - Slope Concept
    public int candy(int[] ratings) {

        int sum =1;
        int i=1;
        while(i<ratings.length){
            if(ratings[i] == ratings[i-1]){
                sum +=1;
                i++;
                continue;
            }

            int peak=1;
            while(i<ratings.length && ratings[i]>ratings[i-1]){
                peak++;
                sum += peak;
                i++;
            }

            int down =1;
            while(i<ratings.length && ratings[i]<ratings[i-1]){

                sum += down;
                down++;
                i++;
            }

            if(down > peak){
                sum +=down-peak;
            }
        }
        return sum;
    }


}
