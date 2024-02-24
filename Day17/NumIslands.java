package Day17;
/*
 3. Problem: Number of Islands

Problem Statement:
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 return the number of islands. An island is surrounded by water and is formed by connecting adjacent lands
 horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Input:
A 2D binary grid.

Output:
The number of islands.

Example:
Input:
grid = [
['1','1','1','1','0'],
['1','1','0','1','0'],
['1','1','0','0','0'],
['0','0','0','0','0']
]
Output:
1
 */
public class NumIslands {
 
    public static void isIsland( String [][] grid, int i, int j){
        int m= grid.length;
        int n= grid[0].length;
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]=="0"){
            return;
        }
        grid[i][j]="0";

        isIsland(grid, i+1, j);
        isIsland(grid, i-1, j);
        isIsland(grid, i, j+1);
        isIsland(grid, i, j-1);
    }
    public static int NumIsland(String [][] grid){
        if(grid == null || grid.length == 0|| grid[0].length == 0){
            return 0;
        }
 
        int cnt=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == "1"){
                    cnt++;
                   isIsland(grid, i, j);
                   
                }
            }
        }
        return cnt;
    }
    public static void main(String args[]){
        String [][] grid={
            {"1","1","0","0","0"},
            {"1","1","0","0","0"},
            {"0","0","1","0","0"},
            {"0","0","0","1","1"}
        };
       System.out.println( NumIsland(grid));
    }
}
