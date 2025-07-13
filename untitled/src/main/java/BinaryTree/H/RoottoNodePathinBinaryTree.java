package BinaryTree.H;

public class RoottoNodePathinBinaryTree {

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

    //Inorder Traversal
    public boolean findPath(TreeNode root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }

        path.append(root.val).append(" ");

        if (root.val == target) {
            return true;
        }

        if (findPath(root.left, target, path) || findPath(root.right, target, path)) {
            return true;
        }

        // If not found in either subtree, remove the current node from the path
        path.setLength(path.length() - 2); // Remove last two characters (value and space)
        return false;
    }
}
