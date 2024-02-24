package Day17;
/*
 * 2. Problem: Word Search

Problem Statement:
Given a 2D board and a word, find if the word exists in the grid. The word can be constructed from letters 
of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring.
 The same letter cell may not be used more than once.

Input:
A 2D board of characters and a word.

Output:
True if the word exists in the grid, otherwise false.

Example:
Input:
board = [
['A','B','C','E'],
['S','F','C','S'],
['A','D','E','E']
]
word = "ABCCED"
Output:
True
 */
public class WordSearch {
    private static boolean visited[][];

   public static boolean dfs(char [][] board, int i, int j,String w, int idx){

    if(idx == w.length()){
        return true;
    }
    if(i<0 || i>= board.length || j<0 || j>= board[i].length || w.charAt(idx) != board[i][j] || visited[i][j] ){
        return false;
    }
    visited[i][j]=true;
    if(dfs(board,i+1,j,w,idx+1) 
    || dfs(board,i-1,j,w,idx+1)
    || dfs(board,i,j+1,w,idx+1)
    || dfs(board,i,j-1,w,idx+1) ){
        return true;
    }
    visited[i][j]=false;
    return false;

   }
   
    public static boolean CheckWord(char [][] board, String w){

        if(w.length()==0 || board.length==0){
            return false;
        }
        int m= board[0].length;
        int n= board.length;
        visited= new boolean[m][n];

        //search the first char of the word in the board
        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++ ){
                {
                    //when found then searched the same word and the next char in the given word
                    if(board[i][j]== w.charAt(0) && dfs(board,i,j,w,0)){
                        return true;
                    }
                }
        }
    } 
    return false;
    }

    public static void main(String args[]){
        char [][] board={
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word= "ABCCED";
        System.out.println(CheckWord(board, word));
    }
}

