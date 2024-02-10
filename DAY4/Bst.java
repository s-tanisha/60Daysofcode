package DAY4;
/*
Problem: Binary Search Tree (BST) Implementation

Problem Statement:
Implement a binary search tree (BST) data structure along with insertion and search operations.

Input:
Commands to insert and search elements in the BST.

Output:
Results of insertion and search operations.

Example:
Input:
Insert: 5, 3, 8, 2, 7
Search: 3, 6
Output:
Inserted: 5, 3, 8, 2, 7
Found: 3
Not Found: 6
 */
public class Bst {
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    public Node root;

    public Node insertion(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertion(root.left, key);
        } else if (key > root.key) {
            root.right = insertion(root.right, key);
        }
        return root;
    }

    public void search(int key) {
        searchRecursive(root, key);
    }

    private void searchRecursive(Node root, int key) {
        if (root == null) {
            System.out.println("Not Found");
            return;
        }
        if (key == root.key) {
            System.out.println("Found");
        } else if (key < root.key) {
            searchRecursive(root.left, key);
        } else {
            searchRecursive(root.right, key);
        }
    }

    public static void main(String args[]) {
        Bst bst = new Bst();
        int arr[] = {5, 3, 8, 2, 7};
        for (int key : arr) {
            bst.root = bst.insertion(bst.root, key);
        }
        bst.search(3);
        bst.search(6);
    }
}
