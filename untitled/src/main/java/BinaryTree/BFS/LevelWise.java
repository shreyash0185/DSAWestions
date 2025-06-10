package BinaryTree.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelWise {

    // Definition for a binary tree node.
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

    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null)return ans;

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){

                TreeNode top = q.remove();
                list.add(top.val);

                if(top.left != null){
                    q.add(top.left);
                }
                if(top.right != null){
                    q.add(top.right);
                }

            }
            ans.add(list);

        }
        return ans;
    }

    //Main method for testing
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        LevelWise levelWise = new LevelWise();
        List<List<Integer>> result = levelWise.levelOrder(root);
        System.out.println(result); // Output: [[1], [2, 3], [4, 5]]
    }
}
