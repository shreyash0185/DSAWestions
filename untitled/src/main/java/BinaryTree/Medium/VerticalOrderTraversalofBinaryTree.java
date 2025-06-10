package BinaryTree.Medium;


import java.util.*;
// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
class Tuple{
    TreeNode node;
    int row ;
    int col;
    public Tuple(TreeNode node , int row , int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

public class VerticalOrderTraversalofBinaryTree {


        public List<List<Integer>> verticalTraversal(TreeNode root) {

            TreeMap<Integer , TreeMap<Integer , PriorityQueue<Integer>>> map = new TreeMap<>();

            Queue<Tuple> q = new LinkedList<Tuple>();

            q.offer(new Tuple(root,0,0));
            while(!q.isEmpty()){
                Tuple tuple = q.poll();
                TreeNode node = tuple.node;
                int x = tuple.row;
                int y = tuple.col;


                if (!map.containsKey(x)) {
                    map.put(x, new TreeMap<>());
                }
                if (!map.get(x).containsKey(y)) {
                    map.get(x).put(y, new PriorityQueue<>());
                }

                map.get(x).get(y).offer(node.val);

                if(node.left !=null){
                    q.offer(new Tuple(node.left, x-1 ,y+1));
                }

                if(node.right != null){
                    q.offer(new Tuple(node.right ,x+1,y+1));
                }
            }

            List<List<Integer>> list = new ArrayList<>();
            for(TreeMap<Integer ,PriorityQueue<Integer>> ys :map.values()){
                list.add(new ArrayList<>());
                for(PriorityQueue<Integer> nodes : ys.values()){
                    while(!nodes.isEmpty()){
                        System.out.println(nodes.peek());
                        list.get(list.size()-1).add(nodes.poll());
                    }
                }
            }
            return list;

        }
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        VerticalOrderTraversalofBinaryTree solution = new VerticalOrderTraversalofBinaryTree();
        List<List<Integer>> result = solution.verticalTraversal(root);

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
