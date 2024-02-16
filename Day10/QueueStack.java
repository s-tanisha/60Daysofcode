package Day10;
/*
 2. Problem: Implement Queue using Two Stacks

Problem Statement:
Implement a queue data structure using two stacks and provide functions to enqueue, dequeue, and check if the queue is empty.

Input:
Commands to enqueue elements into the queue, dequeue elements from the queue, and check if the queue is empty.

Output:
Results of enqueue, dequeue operations, and whether the queue is empty.

Example:
Input:
Enqueue: 5, 3, 8, 2
Dequeue: 
Is Empty?
Output:
Enqueued: 5, 3, 8, 2
Dequeued: 5
Queue is not empty

 */
import java.util.*;

public class QueueStack {
    private  static Stack<Integer> fs;
    private  static Stack<Integer> ss;
    public QueueStack(){
        fs= new Stack<>();
        ss= new Stack<>();
    }
    public void Enqueue(int val){
        fs.push(val);
    }
    public void Dequeue(){
        
        while(!fs.empty()){
            ss.push(fs.pop());
        }
        System.out.println("Dequeued "+ ss.pop());
        while(!ss.empty()){
            fs.push(ss.pop());
        }
    }
    public boolean isEmpty(){
        if(ss.empty() && fs.empty()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String args[]){
       QueueStack Q = new QueueStack();

       Q.Enqueue(5);
       Q.Enqueue(3);
       Q.Enqueue(8);
       Q.Enqueue(2);
       
       Q.Dequeue();
       System.out.println(Q.isEmpty());
       Q.Dequeue();
       Q.Dequeue();
       Q.Dequeue();
       System.out.println(Q.isEmpty());

    }
}
