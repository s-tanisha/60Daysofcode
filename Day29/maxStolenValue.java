package Day29;
/*
 * 1. Find maximum possible stolen value from houses
There are N houses built in a line, each of which contains 
some value in it. A thief is going to steal the maximum value
 of these houses, but he can’t steal in two adjacent houses because 
 the owner of the stolen houses will tell his two neighbors left and 
 right sides. The task is to find what is the maximum stolen value.

Examples: 

Input: hval[] = {6, 7, 1, 3, 8, 2, 4}
Output: 19
Explanation: The thief will steal 6, 1, 8 and 4 from the house.

Input: hval[] = {5, 3, 4, 11, 2}
Output: 16
Explanation: Thief will steal 5 and 11
 */

import java.util.*;

public class maxStolenValue {
    public static int findMaxValue(int price[]){
        int n=price.length;
        if(n==0) return 0;
        
        int []dp = new int[n];

        dp[0]=price[0];
        dp[1]= Math.max(price[0],price[1]);
        
        for(int i =2;i<n;i++){
            dp[i]= Math.max(dp[i-2]+price[i], dp[i-1]);
        }
        return dp[n-1];
    }
    
    
    public static void main(String args[]){
        int hPrice []={6, 7, 1, 3, 8, 2, 4};
        int stoleValue= findMaxValue(hPrice);
        System.out.println(stoleValue);

    }
}
