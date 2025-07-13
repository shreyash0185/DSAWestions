package BinaryTree.H;
import java.util.HashMap;
import java.util.HashSet;

public class ConstructtheBinaryTreefromPostorderandInorderTraversal {


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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || postorder.length  != inorder.length){
            return null;
        }

        HashMap<Integer , Integer > map = new HashMap<Integer , Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i] , i);
        }

        return buildTreePostIn(inorder , 0 , inorder.length -1 , postorder , 0 , postorder.length - 1 , map);

    }

    private TreeNode buildTreePostIn(int[]  inorder , int is , int ie ,  int[] postorder , int ps , int pe , HashMap<Integer , Integer> map ){
        if(ps > pe || is > ie)return null;

        TreeNode root = new TreeNode(postorder[pe]);

        int inRoot = map.get(postorder[pe]);
        int numsLeft = inRoot - is;
        root.left = buildTreePostIn(inorder , is , inRoot -1 ,postorder , ps , ps + numsLeft - 1 , map);

        root.right = buildTreePostIn(inorder , inRoot+1 , ie , postorder , ps + numsLeft , pe-1 , map);

        return root;
    }
}
