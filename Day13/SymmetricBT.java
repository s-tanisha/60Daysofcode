package Day13;
/*
 * 1. Problem: Check if Binary Tree is Symmetric

Problem Statement:
Given a binary tree, determine if it is symmetric around its center.

Input:
A binary tree.

Output:
True if the binary tree is symmetric, otherwise false.

Example:
Input:
1
/
2 2
/ \ /
3 4 4 3
Output:
True
 */

 /*binary tree being symmetric around its center, it means that the left
  and right subtrees of the root are mirror images of each other. */
public class SymmetricBT {
    static class Node{
        int val;
        Node left, right;
        public Node(int v){
            this.val=v;
            this.right = this.left = null;
        }
    }

    public static boolean isSymmetric(Node right, Node left){
        if(left ==null && right == null){
            return true;
        }
        if(left==null || right == null){
            return false;
        }
        return (right.val == left.val) &&(isSymmetric(right.right, left.left)) && (isSymmetric(right.left, left.right));
    }
    public static boolean BTree(Node root){
        if(root ==null){
            return true;
        }
        return isSymmetric(root.right, root.left);
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.right= new Node(2);
        root.left = new Node(2);
        root.left.left= new Node(3);
        root.left.right= new Node(4);
        root.right.left= new Node(4);
        root.right.right = new Node(3);
        // root.left.left.left = new Node(5);

        System.out.println(BTree(root));
    }

}
