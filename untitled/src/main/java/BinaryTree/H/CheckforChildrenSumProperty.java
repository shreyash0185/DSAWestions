package BinaryTree.H;

public class CheckforChildrenSumProperty {

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

    public void isSumProperty(TreeNode root) {
        // Base case: if the node is null, it satisfies the property
        if (root == null) {
           return ;
        }
        int child =0;
        if(root.left != null){
            child += root.left.val;
        }
        if(root.right != null){
            child += root.right.val;
        }

        if(root.val >= child){
            root.val = child;
        }
        else {
            if(root.left != null){
                root.left.val = root.val;
            }
            else if (root.right != null) {
                root.right.val = root.val;
            }
        }

        // Recursively check the left and right subtrees
        isSumProperty(root.left) ;
        isSumProperty(root.right);

        int total = 0;
        if(root.left != null){
            total += root.left.val;
        }
        if(root.right != null){
            total += root.right.val;
        }
        // Check if the current node's value is equal to the sum of its children's values
       if(root.left != null || root.right != null){
           root.val = total;
        }


    }
}
