package Day6;

import javax.swing.text.Position;

/*
 3. Problem: Fibonacci Sequence using Dynamic Programming

Problem Statement:
Write a dynamic programming solution to find the nth Fibonacci number.

Input:
An integer n.

Output:
The nth Fibonacci number.

Example:
Input:
n = 6
Output:
Fibonacci number at position 6: 8
 */
public class FibonacciDP {
    public static int Fibonacci(int n){
        if(n<=1){
            return n;
        }
        int fb[]= new int[n+1];
        fb[0]= 0;
        fb[1]=1;

        for(int i=2; i<=n;i++){
            fb[i]= fb[i-1]+fb[i-2];
        }
        return fb[n];
    }
    public static void main(String args[]){
        int n=6;
        int position= Fibonacci(n);
        System.out.println(position);
    }
    
}
