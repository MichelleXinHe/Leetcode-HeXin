public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null) return false;
        int n=board.length;
        Set<Character> set=null;
        //check rows
        for(int i=0; i<n; i++){
            set=new HashSet<Character>();
            for(int j=0; j<n;j++){
                if(board[i][j]!='.'){
                    if(set.contains(board[i][j])) return false;
                    set.add(board[i][j]);
                }
            }
        }
        
        for(int i=0; i<n; i++){
            set=new HashSet<Character>();
            for(int j=0; j<n;j++){
                if(board[j][i]!='.'){
                    if(set.contains(board[j][i])) return false;
                    set.add(board[j][i]);
                }
            }
        }
        
        int offset=n/3;
        //i and j are the start point of each 9 sub grids
        for(int i=0; i<n;i+=offset){
            for(int j=0; j<n; j+=offset){
                //need to initialize the set here
                set=new HashSet<Character>();
                for(int m=0; m<offset;m++){
                    for(int q=0; q<offset;q++){
                        if(board[i+m][j+q]!='.'){
                            if(set.contains(board[i+m][j+q])) return false;
                            set.add(board[i+m][j+q]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
