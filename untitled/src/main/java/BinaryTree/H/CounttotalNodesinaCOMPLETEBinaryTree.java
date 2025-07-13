package BinaryTree.H;

public class CounttotalNodesinaCOMPLETEBinaryTree {

    public class BinaryTreeNode<T> {
        T val;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        BinaryTreeNode(T x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public int countNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) + countNodes(root.right);
        } else {
            return (1 << rightHeight) + countNodes(root.left);
        }
    }

    private int getHeight(BinaryTreeNode<Integer> node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
}
