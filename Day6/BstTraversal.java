package Day6;
/*
 * 1. Problem: Binary Tree Traversal

Problem Statement:
Implement functions to perform in-order, pre-order, and post-order traversals of a binary tree.

Input:
A binary tree.

Output:
The elements visited during each traversal.

Example:
Input:
1
/
2 3
/
4 5
Output:
In-order Traversal: 4 -> 2 -> 5 -> 1 -> 3
Pre-order Traversal: 1 -> 2 -> 4 -> 5 -> 3
Post-order Traversal: 4 -> 5 -> 2 -> 3 -> 1
 */

public class BstTraversal {
    static class Node{
        int value;
        Node left;
        Node right;
        public Node(int v){
            this.value=v;
            this.right= this.left=null;
        }
    }

        public static void Inorder(Node root){
            if(root !=null){
                Inorder(root.left);
                System.out.print(root.value+" ");
                Inorder(root.right);
            }
        }

        public static void preorder(Node root){
            if(root !=null){
                
                System.out.print(root.value+" ");
                Inorder(root.left);
                Inorder(root.right);
            }
        }

        public static void postorder(Node root){
            if(root !=null){   
                Inorder(root.left);
                Inorder(root.right);
                System.out.print(root.value+" ");
            }
        }
        

        public static void main(String args[]){
            Node root = new Node(1);
            root.left= new Node(2);
            root.right = new Node(3);
            root.left.left= new Node(4);
            root.left.right = new Node(5);

            System.out.println("Inorder Traversal");
            Inorder(root);
            System.out.println();

            System.out.println("prerder Traversal");
            preorder(root);
            System.out.println();

            System.out.println("postorder Traversal");
            postorder(root);
            System.out.println();

        }
    
}
