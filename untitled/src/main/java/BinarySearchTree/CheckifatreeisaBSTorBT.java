package BinarySearchTree;

public class CheckifatreeisaBSTorBT {

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

    public boolean isBST(TreeNode root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(TreeNode node, int min, int max) {
        if (node == null) return true;

        if (node.val < min || node.val > max) return false;

        return isBSTUtil(node.left, min, node.val - 1) && isBSTUtil(node.right, node.val + 1, max);
    }
}
