package Day7;
/*
 * Problem: Minimum Number of Coins

Problem Statement:
Given a list of coin denominations and a target amount, write a function to find the minimum number of coins needed to make up that amount.

Input:
A list of coin denominations and a target amount.

Output:
The minimum number of coins needed to make up the target amount.

Example:
Input:
Denominations: [1, 2, 5]
Target amount: 11
Output:
Minimum number of coins: 3 (2 coins of denomination 5, 1 coin of denomination 1)

 */
public class MinCoin {
    public static int MinNumCoin(int t, int deno[]){
    int dp[]= new int[t+1];
    dp[0]=0;

    for(int i=1; i<=t; i++){
        dp[i]= Integer.MAX_VALUE;
        for(int coin : deno){
            if(i>=coin && dp[i-coin] != Integer.MAX_VALUE){
                dp[i]= Math.min(dp[i], dp[i-coin]+1);
            }
        }
    }
    return dp[t] == Integer.MAX_VALUE ? -1 : dp[t];
    }
    public static void main(String args[]){
        int Target=11;
        int Deno[]={1,2,5};

       System.out.println( MinNumCoin(Target,Deno));
    }
}
