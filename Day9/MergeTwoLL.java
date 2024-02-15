package Day9;
/*
 * Problem Statement:
Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

Input:
Two sorted linked lists.

Output:
A new sorted linked list after merging the input lists.

Example:
Input:
List 1: 1 -> 2 -> 4
List 2: 1 -> 3 -> 4
Output:
1 -> 1 -> 2 -> 3 -> 4 -> 4
 */

public class MergeTwoLL {
    static class Node{
        int data;
        Node next;
        public Node(int d){
            this.data= d;
            this.next=null;
        }
    }
  
    public static Node SortMergeLL(Node L1, Node L2){
        Node main = new Node(0);
        Node head = main;
        while(L1 !=null && L2 !=null){
            if(L1.data <= L2.data){
                head.next=L1;
                L1=L1.next;
            }else{
                head.next=L2;
                L2=L2.next;
            }
            head=head.next;
        }
        if(L1 !=null){
            head.next = L1;
        }else{
            head.next= L2;
        }
        return main.next;
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
        Node LLl = new Node(1);
        LLl.next = new Node(2);
        LLl.next.next = new Node(4);

        Node LLr = new Node(1);
        LLr.next = new Node(3);
        LLr.next.next = new Node(5);

        Node Merge = SortMergeLL(LLl, LLr);
        PrintLL(Merge);
    }
    
}
