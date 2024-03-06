package Day21;
/*
 * Day 21: Trees and Graphs
Easy Problem: Validate Binary Search Tree

Problem Statement:
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

Input:
The root of a binary tree.

Output:
True if the binary tree is a valid BST, otherwise false.

Example:
Input:
    2
   / \
  1   3
Output:
True
 */
public class ValidBST {
    static class Node{
        int val;
        Node left,right;
        public Node(int v){
            this.val=v;
            this.left= this.right=null;
        }
    }
    public static boolean isValidBST(Node root){
        if(root==null){
            return true;
        }
        Node temp=root;
        
        return checkBST(temp);
    }
    private static boolean checkBST(Node root){
        if(root==null){
            return true;
        }
        Node left= root.left;
        Node right= root.right;
        if(!checkBST(left)){
            return true;
        }
        if ((left != null && left.val > root.val) || (right != null && right.val < root.val)) {
            return false;
        }
       
        if(checkBST(right)){
            return false;
        }
        return true;
    }
    public static void main(String args[]){
        Node root= new Node(10);
        root.right=new Node(15);
        root.left = new Node(5);
        root.left.left= new Node(2);
        root.left.right= new Node(8);
        root.right.left= new Node(199);
        root.right.right= new Node(20);
        System.out.println(isValidBST(root));
    }
}
