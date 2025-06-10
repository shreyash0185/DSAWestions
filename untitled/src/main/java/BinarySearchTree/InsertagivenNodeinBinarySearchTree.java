package BinarySearchTree;

public class InsertagivenNodeinBinarySearchTree {



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

    //Iterative approach
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)return new TreeNode(val);
        TreeNode curr = root;

        while(true){
            if(val <= curr.val){
                if(curr.left != null){
                    curr = curr.left;
                }else{
                    curr.left = new TreeNode(val);
                    break;
                }
            }else{
                if(curr.right != null){
                    curr = curr.right;
                }else{
                    curr.right = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    //Recursive approach
    public TreeNode insertIntoBSTRecursive(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) {
            root.left = insertIntoBSTRecursive(root.left, val);
        } else {
            root.right = insertIntoBSTRecursive(root.right, val);
        }
        return root;
    }



}
