package BinaryTree.H;

import java.util.Queue;
import java.util.LinkedList;

public class SerializanddeserializeBinaryTree {

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


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null)return "";

        StringBuilder s = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr == null){
                s.append("n ");
                continue;
            }

            s.append(curr.val+" ");
            q.add(curr.left);
            q.add(curr.right);
        }

        return s.toString();


    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "")return null;


        Queue<TreeNode> q = new LinkedList<>();

        String[] values = data.split(" ");
        TreeNode curr = new TreeNode(Integer.parseInt(values[0]));
        q.add(curr);

        for(int i=1;i<values.length;i++){

            TreeNode p = q.poll();

            if(!values[i].equals("n")){

                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                p.left = left;
                q.add(left);


            }

            if(!values[++i].equals("n")){

                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                p.right = right;
                q.add(right);


            }
        }
        return curr;


    }
}
