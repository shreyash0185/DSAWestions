package BinarySearchTree;

public class CeilinaBinarySearchTree {

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

    public int findCeil(TreeNode root, int key) {
        if (root == null) return -1; // or throw an exception

        if (root.val == key) return root.val;

        if (root.val < key) {
            return findCeil(root.right, key);
        }

        int ceil = findCeil(root.left, key);
        return (ceil >= key) ? ceil : root.val;
    }
}
