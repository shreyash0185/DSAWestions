package BinaryTree.H;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class ConstructBinaryTreefrominorderandpreorder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i] , i);
        }

        TreeNode root = buildTree(preorder , 0 , preorder.length-1 , inorder , 0 , inorder.length-1,map);
        return root;

    }

    public TreeNode buildTree(int[] preorder,int perStart , int preEnd , int[] inorder, int inStart , int inEnd , Map<Integer , Integer> inMap){

        if(perStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[perStart]);

        int inRoot = inMap.get(root.val);
        int numLeft = inRoot - inStart;

        root.left = buildTree(preorder, perStart + 1 ,  perStart + numLeft ,  inorder,  inStart ,  inRoot-1 ,inMap);


        root.right =  buildTree(preorder, perStart+numLeft+1 ,  preEnd  ,  inorder,  inRoot+1 ,  inEnd ,inMap);

        return root;
    }
}
