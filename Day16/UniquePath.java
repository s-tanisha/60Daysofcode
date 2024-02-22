package Day16;
/*
 * 2. Problem: Unique Paths

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
//Recursion
// public class UniquePath {

//     public static int TotalPaths(int m, int n, int currR,int currC){
//         if(currR>m || currC>n){
//             return 0;
//         }
//         if(currR==m -1&& currC==n-1){
//             return 1;
//         }
        
//         int totpath= TotalPaths(m, n, currR+1, currC) + TotalPaths(m, n, currR, currC+1);
//         return totpath;
//     }
//     public static void main(String args[]){
//         int m=3,n=7;
//         System.out.println(TotalPaths(m,n,0,0));
//     }
// }

//Optimal methods

public class UniquePath{
    public static int TotPaths(int m, int n){
        int [][] dp= new int[m+1][n+1];
        for(int i=0; i<m;i++){
            dp[i][n-1]=1;
        }
        for(int j=0; j<n;j++){
            dp[m-1][j]=1;
        }
        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0;j--){
                dp[i][j]= dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
    public static void main(String args[]){
        int m=3, n=7;
        System.out.println(TotPaths(m,n));

    }
}
