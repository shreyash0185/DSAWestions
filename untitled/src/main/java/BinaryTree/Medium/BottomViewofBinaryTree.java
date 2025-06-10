package BinaryTree.Medium;


import java.util.Map;
import java.util.Queue;

public class BottomViewofBinaryTree {

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
        BottomViewofBinaryTree.TreeNode node;
        int horizontalDistance;

        Pair(BottomViewofBinaryTree.TreeNode node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }

    // Function to get the bottom view of the binary tree
    public void bottomView(TreeNode root) {

        if (root == null) {
            return; // If the tree is empty, there's nothing to display
        }

        // Create a queue to hold nodes along with their horizontal distance
        Queue<Pair> queue = new java.util.LinkedList<>();
        Map<Integer, Integer> bottomViewMap = new java.util.TreeMap<>();
        int horizontalDistance = 0; // Initialize horizontal distance
        queue.add(new Pair(root, horizontalDistance));


        while (!queue.isEmpty()) {

            Pair curr = queue.poll(); // Get the front element from the queue
            bottomViewMap.put(curr.horizontalDistance, curr.node.val); // Store the last node at this horizontal distance

            if (curr.node.left != null) {
                queue.add(new Pair(curr.node.left, curr.horizontalDistance - 1)); // Move left
            }
            if (curr.node.right != null) {
                queue.add(new Pair(curr.node.right, curr.horizontalDistance + 1)); // Move right
            }
        }

        // Print the bottom view
        for (java.util.Map.Entry<Integer, Integer> entry : bottomViewMap.entrySet()) {
            System.out.print(entry.getValue() + " "); // Print the value of the node at each horizontal distance
        }

    }

    // Main method for testing
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        BottomViewofBinaryTree bvt = new BottomViewofBinaryTree();
        bvt.bottomView(root); // Call the bottom view function
    }

}
