package BinaryTree.H;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class FlattenBinaryTreetoLinkedList {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }



    //Using recursion
    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }
        TreeNode prev = null;
        flattenHelper(root, prev);

    }

    private void flattenHelper(TreeNode root, TreeNode prev) {
        if (root == null) {
            return;
        }

        // Flatten the right subtree first
        flattenHelper(root.right, prev);

        // Flatten the left subtree
        flattenHelper(root.left, prev);

        // Set the current node's right to the previous node
        root.right = prev;

        // Set the current node's left to null
        root.left = null;

        // Update the previous node to the current node
        prev = root;
    }


    //Using Iteration by Stack

    public void flattenIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            // If there is a right child, push it onto the stack
            if (current.right != null) {
                stack.push(current.right);
            }

            // If there is a left child, push it onto the stack
            if (current.left != null) {
                stack.push(current.left);
            }

            // Set the right child to the next node in the stack
            if (!stack.isEmpty()) {
                current.right = stack.peek();
            }

            // Set the left child to null
            current.left = null;
        }
    }


    // Using Morris Traversal
    public void flattenMorris(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if (current.left != null) {
                // Find the rightmost node of the left subtree
                TreeNode rightmost = current.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // Connect the rightmost node to the current's right subtree
                rightmost.right = current.right;

                // Move the left subtree to the right
                current.right = current.left;
                current.left = null; // Set left to null
            }
            // Move to the next node in the flattened tree
            current = current.right;
        }
    }
}
