package Day28;

/*
 *  N - Queens (Hard)

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such
that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. 
You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement,
where 'Q' and '.' both indicate a queen and an empty space, respectively.

Exapmle 1 -
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 */

import java.util.*;

public class Nqueen {
    public static List<List<String>> Qboard(int n){
        List<List<String>>Result= new ArrayList<>();
        char[][] Qboard = new char[n][n];
        for(int i=0; i<n;i++){
            Arrays.fill(Qboard[i], '.');
        }
        solveNQueen(Qboard, 0, Result);
        return Result;
    }
    private static void solveNQueen(char[][] board, int col, List<List<String>> result){
        if(col == board.length){
            result.add(constructBoard(board));
            return;
        }
        for(int row=0; row<board.length; row++){
            if(isValid(board, row,col)){
                board[row][col]='Q';
                solveNQueen(board, col+1, result);
                board[row][col]='.';
            }
        }
    }
    private static boolean isValid(char[][] board, int row, int col){
        for(int i=0; i<col; i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }

        for(int i=row, j=col;i>=0 && j>=0; i--, j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    private static List<String> constructBoard(char[][]board){
        List<String> result = new ArrayList<>();

        for(char[] row:board){
            result.add(String.valueOf(row));
        }
        return result;
    }
    public static void main(String arg[]){
        int n=2;
        List<List<String>> finalBoard= Qboard(n);
        System.out.println(finalBoard);
    }
}
