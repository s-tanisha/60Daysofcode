package Day22;
/*
3. Problem: Edit Distance

Problem Statement:
Given two strings word1 and word2, return the minimum number of 
operations required to convert word1 to word2.

You have the following three operations permitted on a word:

- Insert a character
- Delete a character
- Replace a character

Input:
Two strings word1 and word2.

Output:
The minimum number of operations required to convert word1 to word2.

Example:
Input:
word1 = "horse", word2 = "ros"
Output:
3
Explanation: 
- Replace 'h' with 'r'.
- Remove 'r'.
- Remove 'e'.
 */

public class EditDistance {
    public static int MinOperationReq(String word1, String word2){
        int n=word1.length();
        int m=word2.length();

       int[][] dp = new int[m+1][n+1];
        
        for(int i =0; i<m;i++){
            dp[i][0]=i;
        }
        for(int j=0; j<n; j++){
            dp[0][j]=j;
        }

        for(int i=1; i<m;i++){
            for(int j=1; j<n; j++){
                if(word1.charAt(j-1) == word2.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1+ Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String args[]){
        String str1="horse";
        String str2="ros";
        int n= MinOperationReq(str1, str2);

        System.out.println(n);
    }
}
