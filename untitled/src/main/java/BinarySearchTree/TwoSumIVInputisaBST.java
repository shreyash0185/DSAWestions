//package BinarySearchTree;
//
//import java.util.Stack;
//
//public class TwoSumIVInputisaBST {
//
//
//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//            left = null;
//            right = null;
//        }
//    }
//
//    public boolean findTarget(TreeNode root, int k) {
//
//
//        if(root == null) return false;
//
//        BSTIterator l = new BSTIterator(root, false);
//        BSTIterator r = new BSTIterator(root, true);
//
//        int i = l.next();
//        int j = r.next();
//
//        while(i < j){
//            if(i + j == k) return true;
//
//            else if(i + j > k){
//                j = r.next();  // FIXED: call next on r
//            } else {
//                i = l.next();  // FIXED: call next on l
//            }
//        }
//        return false;
//    }
//}
//
//
//
//class BSTIterator {
//
//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//            left = null;
//            right = null;
//        }
//    }
//
//    private Stack<TreeNode> stack = new Stack<>();
//    boolean reverse = true;
//    public BSTIterator(TreeNode root , boolean isReverse) {
//        reverse = isReverse;
//        pushAll(root);
//    }
//
//    public int next() {
//        TreeNode temp = stack.pop();
//        if(reverse == false){
//            pushAll(temp.right);
//        }else{
//            pushAll(temp.left);
//        }
//
//        return temp.val;
//    }
//
//    public boolean hasNext() {
//
//        return !stack.isEmpty();
//
//    }
//
//    private void pushAll(TreeNode node){
//        while(node != null){
//            stack.push(node);
//            if(reverse == true){
//                node = node.right;
//            }else{
//                node = node.left;
//            }
//        }
//    }
//}
