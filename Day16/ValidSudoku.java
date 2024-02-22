package Day16;
/*
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 */
public class ValidSudoku {
    public static boolean isRowValid(String [][] board, String c, int idx){
        int db=0;
        int num =Integer.parseInt(c);
        for(int i=0; i<board.length;i++){
          int compare = Integer.parseInt(board[idx][i]);
            if(num== compare){
                db++;
                if(db>1){
                    return false;
                }
            }
        }
        return true;

    }
    public static boolean isColumnValid(String [][] board, String c, int idx){
        int num =Integer.parseInt(c);
        int db = 0;
        for(int i=0; i<board.length;i++){
          int compare = Integer.parseInt(board[i][idx]);
            if(num== compare){
                db++;
                if(db>1){
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean isBlockValid(String [][] board, String c){
        int num =Integer.parseInt(c);
        int db=0;
        for(int i=0; i<3;i++){
            for(int j=0; j<3; j++){
                
                int compare=Integer.parseInt(board[i][j]);
                if(num == compare){
                    db++;
                if(db>1){
                    return false;
                }
                }
            }
        }
        return true;

    }
    public static boolean CheckValidSudoku(String [][] board){
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j]!="."){
                    int col =j;
                    int row=i;
                if(!(isRowValid(board, board[i][j], row)) || !(isColumnValid(board, board[i][j], col))|| !((isBlockValid(board, board[i][j])))){
                    return false;
                }
            }
            }
        }
        return true;
    }
    public static void main(String args[]){
        String[][] board= 
        {{"5","3",".",".","7",".",".",".","."}
        ,{"6",".",".","1","9","5",".",".","."}
        ,{".","9","8",".",".",".",".","6","."}
        ,{"8",".",".",".","6",".",".",".","3"}
        ,{"4",".",".","8",".","3",".",".","1"}
        ,{"7",".",".",".","2",".",".",".","6"}
        ,{".","6",".",".",".",".","2","8","."}
        ,{".",".",".","4","1","9",".",".","5"}
        ,{".",".",".",".","8",".",".","7","9"}};

        System.out.println(CheckValidSudoku(board));
        System.out.println(board.length);
        // for (int i = 0; i < board.length; i++) {
        //     for (int j = 0; j < 2; j++) {
        //         System.out.print(Mergedinterval[i][j] + " ");
        //     }
        //     System.out.println(); // Move to the next line after each row
        // }
    }
}
