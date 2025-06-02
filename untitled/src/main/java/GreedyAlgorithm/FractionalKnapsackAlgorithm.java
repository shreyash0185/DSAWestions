package GreedyAlgorithm;

public class FractionalKnapsackAlgorithm {

    public static class Item {
        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
    /**
     * Solves the fractional knapsack problem using a greedy approach.
     *
     * @param capacity The maximum weight capacity of the knapsack.
     * @param items    An array of items, each with a value and weight.
     * @return The maximum value that can be obtained by filling the knapsack.
     */

    public static double fractionalKnapsack(int capacity, Item[] items) {
        // Sort items by value-to-weight ratio in descending order
        java.util.Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                // If the item can be fully added
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                // If the item can only be partially added
                totalValue += (double) item.value * capacity / item.weight;
                break; // Knapsack is full
            }
        }

        return totalValue;
    }
}
