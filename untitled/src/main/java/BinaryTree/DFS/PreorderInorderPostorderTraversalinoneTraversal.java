package BinaryTree.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderInorderPostorderTraversalinoneTraversal {

    // Definition for a binary tree node
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    // Pair class to hold a TreeNode and its state
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

   //Iterative approch in one travesal create 3 lists for Preorder, Inorder and Postorder traversal with pair class stack Node and Valie - 1 , 2 , 3
    public void preorderInorderPostorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        // Create three lists to hold the results
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        // Stack to hold nodes and their state
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1)); // Start with root node

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            TreeNode node = current.getKey();
            int state = current.getValue();

            if (state == 1) { // Pre-order state
                preorder.add(node.val);
                stack.push(new Pair<>(node, 2)); // Change state to In-order
                if (node.left != null) {
                    stack.push(new Pair<>(node.left, 1)); // Push left child
                }
            } else if (state == 2) { // In-order state
                inorder.add(node.val);
                stack.push(new Pair<>(node, 3)); // Change state to Post-order
                if (node.right != null) {
                    stack.push(new Pair<>(node.right, 1)); // Push right child
                }
            } else if (state == 3) { // Post-order state
                postorder.add(node.val);
            }
        }

        // Print the results
        System.out.println("Pre-order: " + preorder);
        System.out.println("In-order: " + inorder);
        System.out.println("Post-order: " + postorder);
    }


}
