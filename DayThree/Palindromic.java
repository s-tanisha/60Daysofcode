package DayThree;
/*
 Longest Palindromic Subsequence (LPS)

Problem Statement:
Given a string, find the length of the longest palindromic subsequence (LPS).

Input:
A string.

Output:
The length of the longest palindromic subsequence.

Example:
Input:
String: "BBABCBCAB"
Output:
Length of LPS: 7 (LPS: "BABCBAB")
 */
public class Palindromic {

    public static int longestPalindromicSubsequence(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

   
        for (int cl = 2; cl <= n; cl++) {
            for (int i = 0; i < n - cl + 1; i++) {
                int j = i + cl - 1;
                if (str.charAt(i) == str.charAt(j) && cl == 2) {
                    dp[i][j] = 2;
                } else if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

       
        return dp[0][n - 1];
    }
    public static void main (String args[]){
        String str ="BBABCBCAB";
        int length = longestPalindromicSubsequence(str);

        System.out.println(length);
    }
}

