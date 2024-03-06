package Day22;
/*
2. Problem: Unique Paths

Problem Statement:
A robot is located at the top-left corner of a m x n grid. The robot can only move either down or right at any point in time. How many unique paths are there to reach the bottom-right corner of the grid?

Input:
Two integers m and n representing the size of the grid.

Output:
The number of unique paths to reach the bottom-right corner.

Example:
Input:
m = 3, n = 7
Output:
28
 */
public class UniquePath {
    public static int PossiblePath(int m, int n){
        int[][]dp= new int[m][n];
        for(int i=0; i<m; i++){
            dp[i][0]=1;
        }
        for(int i=0; i<n; i++){
            dp[0][i]=1;
        }

        for(int i=1; i<m;i++){
            for(int j=1; j<n;j++){
                dp[i][j]= dp[i-1][j]+dp[i][j-1]; 
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String ars[]){
        int n=7;
        int m=3;
        int result= PossiblePath(m,n);
        System.out.println(result);

    }
}
