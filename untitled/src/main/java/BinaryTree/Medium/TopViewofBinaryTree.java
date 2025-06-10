package BinaryTree.Medium;

import java.util.Map;
import java.util.Queue;

public class TopViewofBinaryTree {

    //Tree Node
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

    //pair class to hold the node and its horizontal distance
    public static class Pair {
        TreeNode node;
        int horizontalDistance;

        Pair(TreeNode node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }

    // Function to get the top view of the binary tree
    public void topView(TreeNode root) {
        // Implementation of top view logic goes here
        // This is a placeholder for the actual implementation
        // You can use a queue or a map to store the nodes at each horizontal distance
        // and then print the first node encountered at each distance.


        if (root == null) {
            return; // If the tree is empty, there's nothing to display
        }

        //Create a queue to hold nodes along with their horizontal distance
        // You can use a map to store the first node at each horizontal distance
        // For example, you can use a HashMap<Integer, Integer> to store the horizontal distance as key
        // and the node value as the value.
        // You can also use a TreeMap to maintain the order of horizontal distances.

        Queue<Pair> queue = new java.util.LinkedList<>();
        Map<Integer, Integer> topViewMap = new java.util.TreeMap<>();
        int horizontalDistance = 0; // Initialize horizontal distance
        queue.add(new Pair(root , horizontalDistance));

        while (!queue.isEmpty()){

            Pair curr = queue.poll();
            if (!topViewMap.containsKey(curr.horizontalDistance)) {
                topViewMap.put(curr.horizontalDistance, curr.node.val); // Store the first node at this horizontal distance
            }
            // Add left child with horizontal distance - 1
            if (curr.node.left != null) {
                queue.add(new Pair(curr.node.left , curr.horizontalDistance - 1)); // Decrease horizontal distance for left child
                // Decrease horizontal distance for left child
            }

            // Add right child with horizontal distance + 1
            if (curr.node.right != null) {
                queue.add(new Pair(curr.node.right , curr.horizontalDistance + 1)); // Decrease horizontal distance for left child

            }


        }
        // Print the top view nodes in order of their horizontal distances
        for (Map.Entry<Integer, Integer> entry : topViewMap.entrySet()) {
            System.out.print(entry.getValue() + " "); // Print the node value
        }


    }

    //main method to test the top view function
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Create an instance of TopViewofBinaryTree and call the topView method
        TopViewofBinaryTree tree = new TopViewofBinaryTree();
        tree.topView(root); // This will print the top view of the binary tree
    }
}
