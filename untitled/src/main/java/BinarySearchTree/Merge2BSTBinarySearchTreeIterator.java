package BinarySearchTree;

import java.util.Stack;

public class Merge2BSTBinarySearchTreeIterator {

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

    class BSTIterator {

        private Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        public int next() {
            TreeNode temp = stack.pop();
            pushAll(temp.right);
            return temp.val;
        }

        public boolean hasNext() {

            return !stack.isEmpty();

        }

        private void pushAll(TreeNode root){
            for(;root != null ; stack.push(root) , root = root.left);
        }
    }

}
