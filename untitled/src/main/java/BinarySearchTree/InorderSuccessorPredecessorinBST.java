package BinarySearchTree;

public class InorderSuccessorPredecessorinBST {
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

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            return findMin(p.right);
        }
        TreeNode successor = null;
        while (root != null) {
            if (p.val < root.val) {
                successor = root;
                root = root.left;
            } else if (p.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return successor;
    }
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (p.left != null) {
            return findMax(p.left);
        }
        TreeNode predecessor = null;
        while (root != null) {
            if (p.val < root.val) {
                root = root.left;
            } else if (p.val > root.val) {
                predecessor = root;
                root = root.right;
            } else {
                break;
            }
        }
        return predecessor;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private TreeNode findMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
