package BinaryTree.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInOrder {

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

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        while(true){

            if(root != null){
                st.add(root);
                root = root.left;
            }else{

                if(st.isEmpty()){
                    break;
                }

                root = st.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;


    }
}
