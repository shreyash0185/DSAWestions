package BinarySearchTree;

public class LargestBSTinBinaryTree {

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

    public class NodeValue{

        public int maxNode , minNode, maxSize;


        NodeValue(int maxNode, int minNode, int maxSize) {
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.maxSize = maxSize;
        }
    };

    public NodeValue largestBSTinBinaryTree(TreeNode root) {

        if(root == null){
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        NodeValue l = largestBSTinBinaryTree(root.left);
        NodeValue r = largestBSTinBinaryTree(root.right);

        if(l.maxNode < root.val && r.minNode > root.val){
            // The current tree is a BST
            return new NodeValue(Math.max(l.maxNode, root.val), Math.min(r.minNode, root.val), l.maxSize + r.maxSize + 1);
        }else{
            // The current tree is not a BST
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(l.maxSize, r.maxSize));
        }
    }

    public int largestBSTinBinaryTreeSize(TreeNode root) {
        return largestBSTinBinaryTree(root).maxSize;
    }








}
