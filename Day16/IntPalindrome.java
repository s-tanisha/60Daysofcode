package Day16;
/*
1. Problem: Palindrome Number

Problem Statement:
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Input:
An integer.

Output:
True if the integer is a palindrome, otherwise false.

Example:
Input:
121
Output:
True
 */
public class IntPalindrome {
    public static boolean isPalindrome(int num){
        int n=num;
        if(n<0){
            return false;
        }
        int reverse=0;
        while(n!=0){
            int digit=n%10;
            reverse = reverse*10 + digit;
            n=n/10;
        }
        return num==reverse;
    }
    public static void main(String args[]){
    int num = 121;
        System.out.println(isPalindrome(num));
    }
}
