package Day10;
/*
 * Problem Statement:
Implement a stack data structure using an array and provide functions to push, pop, and check if the stack is empty.

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
public class Stackarr {

    private static int arr[];
    private static int idx;
    private static final int DEFAULT_CAPACITY=10;
    public Stackarr(){
        arr = new int[DEFAULT_CAPACITY];
        idx=-1;
    }
    public void push(int val){
        idx++;
        arr[idx]= val;
        
    }
    public void pop(){
        System.out.println("Popped : "+ arr[idx]);
        idx--;
    }
    public void Printstack(Stackarr s){
        for(int i=0; i<=idx; i++){
            System.out.println(arr[i]+" ");
        }

    }
    public void isEmpty(){
        if(idx==-1){
            System.out.println("empty");
        }else{
            System.out.println("not empty");
        }
    }
    public static void main(String args[]){
       Stackarr st = new Stackarr();
       st.push(5);
       st.push(3);
       st.push(8);
       st.push(2);

       st.pop();
       
       st.isEmpty();

    }
}
