package DayOne;
/*
 * 3. Problem: Longest Increasing Subsequence

Problem Statement:
Given an unsorted array of integers, find the length of the longest increasing subsequence.

Input:
An array of integers.

Output:
The length of the longest increasing subsequence.

Example:
Input:
[10, 22, 9, 33, 21, 50, 41, 60, 80]
Output:
6 (The LIS is [10, 22, 33, 50, 60, 80])
 */

 import java.util.Arrays;

 public class LongIncSort {
 
     public static int lengthOfLIS(int[] nums) {
 
         if (nums == null || nums.length == 0) {
             return 0;
         }
 
         int n = nums.length;
         int[] dp = new int[n];
         Arrays.fill(dp, 1);
         
         for (int i = 1; i < n; i++) {
             for (int j = 0; j < i; j++) {
                 if (nums[i] > nums[j]) {
                     dp[i] = Math.max(dp[i], dp[j] + 1);
                 }
             }
         }
         int maxi = 1;
         
         for (int len : dp) {
             maxi = Math.max(maxi, len);
         }
         return maxi;
     }
 
     public static void main(String[] args) {
        
         int[] nums = {0, 22, 9, 33, 21, 50, 41, 60, 80};
         int result = lengthOfLIS(nums);
         System.out.println("Length of Longest Increasing Subsequence: " + result);
     }
     }
 
 
