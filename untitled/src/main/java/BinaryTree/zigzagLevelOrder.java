package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class zigzagLevelOrder {

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

    // Zigzag level order traversal of a binary tree
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // Implementation goes here
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;

        boolean flag = true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);


        while(!q.isEmpty()){
            int size = q.size();

            List<Integer> list = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode top = q.remove();
                if(flag){
                    list.add(top.val);
                }else{
                    list.add(0, top.val); // Add to the front of the list
                }

                if(top.left != null){
                    q.add(top.left);
                }
                if(top.right != null){
                    q.add(top.right);
                }
            }
            ans.add(list);
            flag = !flag; // Toggle the flag for the next level

        }
        return ans;

    }


}
