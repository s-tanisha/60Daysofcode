package Day22;
/*
 1. Problem: Climbing Stairs

Problem Statement:
You are climbing a staircase. It takes n steps to reach the top. 
Each time you can either climb 1 or 2 steps. In how many distinct ways
 can you reach the top?

Input:
An integer n representing the number of steps to reach the top.

Output:
The number of distinct ways to reach the top.

Example:
Input:
n = 4
Output:
5
Explanation: There are five ways to climb the stairs: 1 step + 1 step + 1 step + 1 step, 2 steps + 1 step + 1 step, 1 step + 2 steps + 1 step, 1 step + 1 step + 2 steps, 2 steps + 2 steps.

 */
public class ClimbingStairs {
    public static int diffWaysToClimb(int n){
       if(n<=1){
        return 1;
       }

       int[]dp= new int[n+1];
       dp[0]=1;
       dp[1]=1;

       for(int i=2;i<=n;i++){
        dp[i]= dp[i-1]+dp[i-2]
       }

        return dp[n]  ;
    }
    

     
    public static void main(String args[]){
        int n=5;
        System.out.print(diffWaysToClimb(n));
    }
    
}
