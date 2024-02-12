/*
 * 3. Problem: Factorial Calculation using Recursion

Problem Statement:
Write a recursive function to calculate the factorial of a non-negative integer.

Input:
A non-negative integer n.

Output:
The factorial of n.

Example:
Input:
n = 5
Output:
Factorial of 5: 120
 */
public class FactRecur {
    public static int RecursiveFactorial(int n){
        if( n==0){
            return 1;
        }
        return n* RecursiveFactorial(n-1);
    }
    public static void main(String args[]){
        int n=5;
        System.out.println(RecursiveFactorial(n));
    }
}
