package Day9;

import java.util.LinkedList;

/*Problem Statement:
Write a function to reverse a linked list.

Input:
A linked list.

Output:
The reversed linked list.

Example:
Input:
1 -> 2 -> 3 -> 4 -> 5
Output:
5 -> 4 -> 3 -> 2 -> 1
/* */
public class ReverseLL {
    static class Node{
        int data;
        Node next;
        public Node(int d){
            this.data= d;
            this.next=null;
        }
    }
    public static Node ReverseLinkedlist(Node head){
        Node temp=null;
        Node curr = head;
        Node prev=null;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public static void PrintLL(Node head){
        System.out.println("Linked List");
        while(head != null){
            System.out.print(head.data +" -> ");
            head = head.next;
        }
        System.out.println(" ");
    }
    public static void main(String args[]){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        PrintLL(head);
        Node newReverseLL= ReverseLinkedlist(head);
        PrintLL(newReverseLL);
    }
}
