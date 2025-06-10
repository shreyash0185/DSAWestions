package BinaryTree.DFS;

public class InOrder {

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
    // In-order traversal of a binary tree
    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left); // Traverse left subtree
        System.out.print(root.val + " "); // Visit node
        inOrderTraversal(root.right); // Traverse right subtree
    }
}
