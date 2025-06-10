package BinaryTree.Medium;
import java.util.LinkedList;
import java.util.Queue;

public class HeightofaBinaryTree {

    // Definition for a binary tree node
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

    //Recursive approach
    public int maxDepth(TreeNode root) {

        if(root == null)return 0;
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right ));


    }

    //Iterative approach - level order traversal
    public int maxDepthIterative(TreeNode root) {
        if(root == null)return 0;

        int height = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            height++;
            for(int i=0;i<size;i++){
                TreeNode top = q.remove();
                if(top.left != null){
                    q.add(top.left);
                }
                if(top.right != null){
                    q.add(top.right);
                }
            }
        }
        return height;
    }


}
