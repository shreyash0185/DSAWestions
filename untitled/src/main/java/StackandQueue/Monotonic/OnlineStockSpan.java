package StackandQueue.Monotonic;

import java.util.Stack;

//leetcode 901. Online Stock Span
public class OnlineStockSpan {

    Stack<Pair<Integer, Integer>> stack = new Stack<>();
    int idx = -1;

    public OnlineStockSpan() {

        idx = -1;
        stack.clear();

    }

    public int next(int price) {
        idx += 1;
        while (!stack.isEmpty() && stack.peek().getKey() <= price) {
            stack.pop();
        }

        int ans = stack.isEmpty() ? idx + 1 : idx - stack.peek().getValue();

        stack.push(new Pair<>(price, idx));
        return ans;


    }

    // Pair class to hold price and index
    public static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
