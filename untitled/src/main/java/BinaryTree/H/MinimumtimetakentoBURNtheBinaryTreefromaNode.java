package BinaryTree.H;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class MinimumtimetakentoBURNtheBinaryTreefromaNode {

    public class BinaryTreeNode<T> {
        T val;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        BinaryTreeNode(T x) {
            val = x;
            left = null;
            right = null;
        }
    }

    private static BinaryTreeNode<Integer> bfsToMapParents(BinaryTreeNode<Integer> root, HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp, int start) {
        BinaryTreeNode<Integer> target = null;
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> current = queue.poll();
            if (current.val == start) {
                target = current;
            }
            if (current.left != null) {
                mpp.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                mpp.put(current.right, current);
                queue.offer(current.right);
            }
        }
        return target;
    }

    private static int findMaxDistance(BinaryTreeNode<Integer> target, HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp) {
        HashSet<BinaryTreeNode<Integer>> visited = new HashSet<>();
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);
        int maxDistance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> current = queue.poll();
                if (current.left != null && !visited.contains(current.left)) {
                    visited.add(current.left);
                    queue.offer(current.left);
                }
                if (current.right != null && !visited.contains(current.right)) {
                    visited.add(current.right);
                    queue.offer(current.right);
                }
                if (mpp.containsKey(current) && !visited.contains(mpp.get(current))) {
                    visited.add(mpp.get(current));
                    queue.offer(mpp.get(current));
                }
            }
            maxDistance++;
        }
        return maxDistance - 1; // Subtract 1 to get the distance
    }

    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start){
        HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp = new HashMap<>();
        BinaryTreeNode<Integer> target = bfsToMapParents(root, mpp, start);
        int maxi = findMaxDistance(target, mpp);
        return maxi;
    }
}
