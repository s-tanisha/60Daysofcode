package Day16;
/*
 * Problem Statement:
Given a m x n grid filled with non-negative numbers, find a path from the top-left corner to the bottom-right corner, which minimizes the sum of all numbers along its path. You can only move either down or right at any point in time.

Input:
A m x n grid filled with non-negative integers.

Output:
The minimum sum of all numbers along the path from the top-left corner to the bottom-right corner.

Example:
Input:
grid = [
[1,3,1],
[1,5,1],
[4,2,1]
]
Output:
7
 */
//Dynamic programing 
public class MinSumPath {
    public static int MinSumInPath(int [][]grid){
        int m= grid[0].length;
        int n= grid.length;
        int [][]dp = new int[m][n];

        dp[0][0]= grid[0][0];

        for(int i=1; i<m;i++){
            dp[i][0]= dp[i-1][0]+ grid[i][0];
        }

        for(int j=1; j<n; j++){
            dp[0][j]= dp[0][j-1]+ grid[0][j];
        }

        for(int i=1; i<m;i++){
            for(int j=1; j<n; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String args[]){
        int [][]grid={
            {1,3,1}, {1,5,1},{4,2,1}
        };
       System.out.println(MinSumInPath(grid));
       
    }
}
