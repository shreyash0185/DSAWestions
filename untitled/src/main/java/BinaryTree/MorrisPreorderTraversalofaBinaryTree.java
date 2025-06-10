package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreorderTraversalofaBinaryTree {

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

    public List<Integer> preorderTraversal(TreeNode root) {

        TreeNode curr = root;
        List<Integer> ans = new ArrayList<>();

        while(curr != null){

            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = curr;
                    ans.add(curr.val);
                    curr = curr.left;

                }
                else{
                    prev.right = null;

                    curr = curr.right;
                }
            }
        }
        return ans;


    }
}
