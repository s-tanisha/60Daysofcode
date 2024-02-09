package DayTwo;

/*
  3.Problem : Longest Common Subsequence (LCS)

Problem Statement:
Given two strings, find the length of the longest common subsequence (LCS).

Input:
Two strings.

Output:
The length of the longest common subsequence.

Example:
Input:
String 1: "ABCBDAB"
String 2: "BDCAB"
Output:
Length of LCS: 4 (LCS: "BCAB")
 */
public class LCS {

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] dp = new int[2][n + 1];


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + 1;
                } else {
                    dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
                }
            }
        }

        return dp[m % 2][n];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        int result = longestCommonSubsequence(text1, text2);
        System.out.println("Length of Longest Common Subsequence: " + result);
    }
}



