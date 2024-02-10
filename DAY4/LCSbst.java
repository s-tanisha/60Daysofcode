package DAY4;
/*
 * Problem Statement:
Given two sorted arrays, find the length of the longest common subsequence (LCS) using binary search.

Input:
Two sorted arrays.

Output:
The length of the longest common subsequence.

Example:
Input:
Array 1: [1, 3, 5, 7, 9]
Array 2: [3, 5, 8, 9, 10]
Output:
Length of LCS: 3 (LCS: [3, 5, 9])
 */

public class LCSbst {
    public static int LCS(int arr1[], int arr2[]){
        int n= arr1.length;
        int m= arr2.length;

        int dp[][]= new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n ; j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else if(arr1[i-1] == arr2[j-1]){
                    dp[i][j]= dp[i-1][j-1] +1;
                }else{
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String arg[]){
        int arr1[]= {1,3,5,7,9};
        int arr2[]= {3,5,8,9,10};

        System.out.println(LCS(arr1, arr2));
    }
}
