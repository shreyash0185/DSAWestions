package BinarySearchTree;

public class FloorinaBinarySearchTree {
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

    public int findFloor(TreeNode root, int key) {
        if (root == null) return -1; // or throw an exception

        if (root.val == key) return root.val;

        if (root.val > key) {
            return findFloor(root.left, key);
        }

        int floor = findFloor(root.right, key);
        return (floor <= key) ? floor : root.val;
    }
}
