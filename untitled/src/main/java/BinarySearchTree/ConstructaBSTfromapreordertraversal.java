package BinarySearchTree;

public class ConstructaBSTfromapreordertraversal {

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

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder , Integer.MAX_VALUE , new int[]{0});

    }

    public TreeNode helper(int[] preorder , int bound , int[] i) {
        if(i[0] == preorder.length || preorder[i[0]] > bound)return null;

        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = helper(preorder , root.val , i);
        root.right = helper(preorder , bound , i);
        return root;
    }
}
