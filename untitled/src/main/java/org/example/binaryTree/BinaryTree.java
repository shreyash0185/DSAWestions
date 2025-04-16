package org.example.binaryTree;

class Node{
    int key;
    Node left , right;

    public Node(int item){
        key = item;
        left = right =null;

    }
}

public class BinaryTree {

    Node root;

    public BinaryTree(){
        root =null;
    }

    // Method to insert a new node with given key
    public void insert(int key) {
        root = insertRec(root, key);
    }


    // A recursive function to insert a new key in BST
    private Node insertRec(Node root , int key){
        // If the tree is empty, return a new node
        if(root == null){
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if(key<root.key){
            root.left = insertRec(root.left , key);

        }else if(key > root.key)
            root.right = insertRec(root.right , key);


        // return the (unchanged) node pointer
        return root;
    }

    // Method to print the tree inorder
    // left root right
    public void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    private void inorderRec(Node root){
        if(root != null){
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public void preorder() {
        printPreorder(root);
    }

    // Function to print preorder traversal
    // root left right
    public static void printPreorder(Node node){
        if(node == null)
            return;


        // First deal with the node
        System.out.print(node.key + " ");

        // Then recur on left subtree
        printPreorder(node.left);


        // Finally recur on right subtree
        printPreorder(node.right);

    }

    // Function to print postorder traversal

    public void postorder() {
        printPostorder(root);
    }

    // Function to print postorder traversal
    // left right root
    static void printPostorder(Node node)
    {
        if (node == null)
            return;

        // First recur on left subtree
        printPostorder(node.left);

        // Then recur on right subtree
        printPostorder(node.right);

        // Now deal with the node
        System.out.print(node.key + " ");
    }


    // Method to search for a key in the tree
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // A utility function to search for a key in BST
    private boolean searchRec(Node root , int key){
        if(root == null) return false ;

        if(root.key == key) return true;

        if(key < root.key)
            return searchRec(root.left , key);
        else
            return searchRec(root.right, key);
    }

    // Method to find the minimum value in the tree
    public int findMin() {
        return findMinRec(root);
    }

    // A utility function to find the minimum value in BST
    private int findMinRec(Node root) {
        if (root == null)
            throw new IllegalStateException("Tree is empty");

        if (root.left == null)
            return root.key;

        return findMinRec(root.left);
    }

    // Method to find the maximum value in the tree
    public int findMax() {
        return findMaxRec(root);
    }

    // A utility function to find the maximum value in BST
    private int findMaxRec(Node root) {
        if (root == null)
            throw new IllegalStateException("Tree is empty");

        if (root.right == null)
            return root.key;

        return findMaxRec(root.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert some nodes
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print inorder traversal of the tree
        System.out.println("Inorder traversal:");
        tree.inorder();
        // Output: 20 30 40 50 60 70 80
        System.out.println("preorder traversal:");
        tree.preorder();

        System.out.println("postorder traversal:");
        tree.postorder();


        // Search for a key
        int searchKey = 40;
        if (tree.search(searchKey))
            System.out.println("\nKey " + searchKey + " found in the tree.");
        else
            System.out.println("\nKey " + searchKey + " not found in the tree.");

        // Find minimum and maximum values
        System.out.println("Minimum value in the tree: " + tree.findMin());
        System.out.println("Maximum value in the tree: " + tree.findMax());
    }

}


