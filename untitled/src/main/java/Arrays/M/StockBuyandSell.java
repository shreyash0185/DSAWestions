package Arrays.M;

public class StockBuyandSell {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum profit: " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Update the minimum price
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice); // Calculate profit
            }
        }

        return maxProfit; // Return the maximum profit
    }
}
