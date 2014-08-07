//both helper and helper1 work
public class Solution {
    public void solveSudoku(char[][] board) {
        if(board==null) return;
        //helper1(board, 0);
                helper(board);

    }
    
    public boolean helper1(char[][] board, int count){
        if(count==81) return true;
        int row= count/9;
        int col= count%9;
        if(board[row][col]!='.') return helper1(board, count+1);
        
        for(char c='1'; c<='9'; c++){
            board[row][col]=c;
            if(check(board, row, col)&&helper1(board, count+1)) return true;
            board[row][col]='.';
        }
        //there is not solution for this cell based on current assignment
        return false;
    }
    
    public boolean helper(char[][] board){
        int n=board.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n;j++){
                if(board[i][j]=='.'){
                    for(char k='1'; k<='9'; k++){
                        board[i][j]=k;
                        if(check(board, i, j)&&helper(board)) return true;
                        board[i][j]='.';
                    }
                    //if for this unassigned cell, we cannt find out a number that
                    //lead to the solution, there will be no solution here, return false
                    //helper and helper1 in this part share the same idea
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean check(char[][] board, int i, int j){
        char c=board[i][j];
        int n=board.length;
        //check row
        for(int m=0; m<n; m++){
            if(m!=j){
                if(board[i][m]==c) return false;
            }
        }
        
        //check col
        for(int m=0; m<n; m++){
            if(m!=i){
                if(board[m][j]==c) return false;
            }
        }
        
        //check sub-square
        int startRow=3*(i/3), startCol=3*(j/3);
        for(int p=startRow; p<startRow+3; p++){
            for(int q=startCol; q<startCol+3; q++){
                if(p!=i&&q!=j){
                    if(board[p][q]==c) return false;
                }
            }
        }
        return true;
    }
}
