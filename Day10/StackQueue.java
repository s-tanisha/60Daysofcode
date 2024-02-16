package Day10;
/*
 * 3. Problem: Implement Stack using Queue

Problem Statement:
Implement a stack data structure using a queue and provide functions to push, pop, and check if the stack is empty.

Input:
Commands to push elements onto the stack, pop elements from the stack, and check if the stack is empty.

Output:
Results of push, pop operations, and whether the stack is empty.

Example:
Input:
Push: 5, 3, 8, 2
Pop: 
Is Empty?
Output:
Pushed: 5, 3, 8, 2
Popped: 2
Stack is not empty
 */
import java.util.*;

public class StackQueue {
    private static Queue<Integer> q;
    private static int idx;
    public StackQueue(){
        q= new LinkedList<>();
        idx=0;
    }
    public void push(int val){
        idx++;
        q.add(val);

        for(int i =0; i<idx -1; i++){
            q.add(q.remove());
        }
        
    }
    public void pop(){
        System.out.println("popped "+ q.poll());
        idx--;
    }
    public boolean empty(){
        return q.isEmpty();
    }
    public static void main(String args[]){
        StackQueue St= new StackQueue();
        St.push(5);
        St.push(3);
        St.push(8);
        St.push(2);

        St.pop();

        System.out.println(St.empty());

    }
}
