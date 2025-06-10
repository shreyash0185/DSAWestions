package BinaryTree.Medium;

import java.util.List;

public class BoundaryTraversalofBinaryTree {

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

    // Function to perform boundary traversal of the binary tree
    public List<Integer> boundaryTraversal(TreeNode root) {
        if (root == null) return List.of();

        List<Integer> ans = new java.util.ArrayList<>();

        if(!isLeafe(root)) {
            ans.add(root.val);
        }else{

            return ans;
        }

        // Print left boundary
        printLeftBoundary(root.left , ans);


        // Print leaf nodes
        printLeaves(root , ans);



        // Print right boundary
        printRightBoundary(root.right, ans);

        return ans;
    }

    // Helper function to check if a node is a leaf
    private boolean isLeafe(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    private void printLeftBoundary(TreeNode node, List<Integer> ans) {
        if (node == null || (node.left == null && node.right == null)) return;

        ans.add(node.val);

        if (node.left != null) {
            printLeftBoundary(node.left, ans);
        } else {
            printLeftBoundary(node.right, ans);
        }
    }

    private void printLeaves(TreeNode node , List<Integer> ans) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            ans.add(node.val);
            return;
        }

        printLeaves(node.left, ans);
        printLeaves(node.right, ans);
    }

    private void printRightBoundary(TreeNode node, List<Integer> ans) {
        if (node == null || (node.left == null && node.right == null)) return;

        if (node.right != null) {
            printRightBoundary(node.right, ans);
           ans.add(node.val);
        } else {
            printRightBoundary(node.left, ans);
              ans.add(node.val);
        }
    }

    //main method for testing
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        BoundaryTraversalofBinaryTree btt = new BoundaryTraversalofBinaryTree();
        List<Integer> result = btt.boundaryTraversal(root);
        System.out.println(result); // Output: [1, 2, 4, 5, 6, 3]
    }
}
