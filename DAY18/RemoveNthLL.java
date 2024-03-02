package DAY18;
/*
 * Problem: Remove Nth Node From End of List

Problem Statement:
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Input:
The head of a linked list and an integer n.

Output:
The head of the updated linked list after removing the nth node from the end.

Example:
Input:
1 -> 2 -> 3 -> 4 -> 5, n = 2
Output:
1 -> 2 -> 3 -> 5

 */

public class RemoveNthLL {
    public static Node root;
    static class Node{
        int Val;
        Node next; 

        public Node(int v){
            this.Val = v;
            this.next = null;
        }
    }
    
    public static Node RemoveNthNodeEndList(int n, Node root){
    
        Node temp = new Node(0);
        temp.next= root;

        Node fast = temp;
        Node slow = temp;

        for(int i=0; i<=n; i++){
            fast=fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return temp.next;
    }
    public static void PrintLL(Node head){
        System.out.println("Linked List");
        while(head != null){
            System.out.print(head.Val +" -> ");
            head = head.next;
        }
        System.out.println(" ");
    }
    public static void main(String args[]){

        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);

        PrintLL(root);
        int n=2;
        root= RemoveNthNodeEndList(n,root);
        PrintLL(root);

    }
}
