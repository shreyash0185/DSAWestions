package GreedyAlgorithm;

public class MinimumCoins {

    public void minCoins(int amount) {

        int[] coins = {1, 2,5, 10,20,50, 100,500,1000}; // coin denominations

        int[] dp = new int[amount + 1];
        if(amount == 0) {
            System.out.println("No coins needed for amount 0");
            return;
        }
        int n = coins.length;
        for (int i = n-1; i >=0 ; i++) {

            while (amount >= coins[i]) {
                amount -= coins[i];
                dp[coins[i]]++;
            }
        }
        System.out.print("Minimum coins needed: ");
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > 0) {
                System.out.print(dp[i] + " coins of denomination " + i + ", ");
            }
        }


    }
}
