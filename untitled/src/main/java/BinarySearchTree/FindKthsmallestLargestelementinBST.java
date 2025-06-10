package BinarySearchTree;

public class FindKthsmallestLargestelementinBST {

    //Using morris traversal to find the kth smallest element in a BST
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

    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        int count = 0;
        int result = -1;

        while (curr != null) {
            if (curr.left == null) {
                count++;
                if (count == k) {
                    result = curr.val;
                }
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    count++;
                    if (count == k) {
                        result = curr.val;
                    }
                    curr = curr.right;
                }
            }
        }
        return result;
    }


    public int kthLargest(TreeNode root, int k) {
        TreeNode curr = root;
        int count = 0;
        int result = -1;

        while (curr != null) {
            if (curr.right == null) {
                count++;
                if (count == k) {
                    result = curr.val;
                }
                curr = curr.left;
            } else {
                TreeNode prev = curr.right;
                while (prev.left != null && prev.left != curr) {
                    prev = prev.left;
                }

                if (prev.left == null) {
                    prev.left = curr;
                    curr = curr.right;
                } else {
                    prev.left = null;
                    count++;
                    if (count == k) {
                        result = curr.val;
                    }
                    curr = curr.left;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);

        FindKthsmallestLargestelementinBST bst = new FindKthsmallestLargestelementinBST();
        System.out.println("2nd smallest: " + bst.kthSmallest(root, 2)); // Output: 3
        System.out.println("2nd largest: " + bst.kthLargest(root, 2)); // Output: 7
    }
}
