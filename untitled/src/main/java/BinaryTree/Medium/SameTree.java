package BinaryTree.Medium;

public class SameTree {

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

//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (p == null && q == null) return true;
//        if (p == null || q == null) return false;
//
//        if (p.val != q.val) return false;
//
//        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null)return (p==q);

        return (p.val== q.val) && isSameTree(p.left , q.left) &&isSameTree(p.right , q.right);

    }
}
