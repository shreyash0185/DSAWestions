package BinaryTree.H;

public class LCAinBinaryTree {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root == p || root ==q){
            return root;
        }


        TreeNode l = lowestCommonAncestor(root.left , p ,q);
        TreeNode r = lowestCommonAncestor(root.right , p , q);

        if(l == null){
            return r;
        }else if(r == null){
            return l;
        }else{
            return root;
        }
    }
}
