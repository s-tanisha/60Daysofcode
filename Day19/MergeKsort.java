package Day19;
/*
3. Problem: Merge K Sorted Lists

Problem Statement:
Merge k sorted linked lists and return it as one sorted list.

Input:
An array of linked lists.

Output:
The merged sorted linked list.

Example:
Input:
lists = [[1,4,5],[1,3,4],[2,6]]
Output:
[1,1,2,3,4,4,5,6]

 */
import java.util.*;

public class MergeKsort {
    static class Node implements Comparable<Node>{
        int data;
        Node next;
        public Node(int v){
            this.data=v;
            this.next=null;
        }
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.data, other.data);
        }
    }

    public static Node MergeInLL(Node []lists){
        if(lists==null || lists.length==0){
            return null;
        }

        PriorityQueue<Node> minheap = new PriorityQueue<>();

        for(Node list:lists){
            if(list !=null){
                minheap.offer(list);
            }
        }

        Node dummy = new Node(0);
        Node curr = dummy;

        while(!minheap.isEmpty()){
            Node node = minheap.poll();
            curr.next= node;
            curr = curr.next;

            if(node.next != null){
                minheap.offer(node.next);
            }
        }
        return dummy.next;

    }
    public static void PrintList(Node head){
        while (head != null) {
            System.out.print(head.data+ " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String []args){

        List<List<Integer>> list = new LinkedList<>();

        Node list1 = new Node(1);
        list1.next = new Node(4);
        list1.next.next = new Node(5);

        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next = new Node(4);

        Node list3 = new Node(2);
        list3.next = new Node(6);

        Node []Lists= {list1, list2, list3};

        Node Merged = MergeInLL(Lists);

        PrintList(Merged);

    }
}
