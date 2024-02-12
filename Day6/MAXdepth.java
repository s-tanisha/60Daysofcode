package Day6;
/*
 * Problem: Maximum Depth of Binary Tree

Problem Statement:
Write a function to find the maximum depth of a binary tree.

Input:
A binary tree.

Output:
The maximum depth of the binary tree.

Example:
Input:
3
/
9 20
/
15 7
Output:
Maximum Depth: 3
 */
public class MAXdepth {
    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int v){
            this.value = v;
            this.left= this.right= null;
        }
    }
    private static final char[] MAXdepth = null;
    static int Depth=0;
    public static int BstMaxDepth(Node root){
        
        if(root==null){
            return 0;
        }
        Depth++;
       int leftDepth= BstMaxDepth(root.left);
       int rightDepth = BstMaxDepth(root.right);

       return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main (String args[]){
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.left.left = new Node(15);
        root.left.right = new Node(7);
        int MaxDepth= BstMaxDepth(root);
        System.out.println(MaxDepth);
    }
}
