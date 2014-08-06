public class SurroundedRegion {
    //BFS
    public void solve(char[][] board) {
        if(board==null||board.length==0) return;
        int m=board.length;
        int n=board[0].length;
        //x is queue for bfs
        ArrayList<Integer> x=new ArrayList<Integer>();
        ArrayList<Integer> y=new ArrayList<Integer>();
        //visited store visisted points
        Set<String> visited=new HashSet<String>();
        
        //four edges, record the index of points which are 'O'
        for(int i=0; i<n; i++){
            if(board[0][i]=='O'){
                x.add(0);
                y.add(i);
            }
            
            if(board[m-1][i]=='O'){
                x.add(m-1);
                y.add(i);
            }
        }
        
        for(int i=1; i<m-1; i++){
            if(board[i][0]=='O'){
                x.add(i);
                y.add(0);
            }
            
            if(board[i][n-1]=='O'){
                x.add(i);
                y.add(n-1);
            }
        }
        
        //BFS: any 'O' connect to the edge 'O's will be in queue
        while(x.size()>0){
            int xx=x.remove(0);
            int yy=y.remove(0);
            String key=xx+"+"+yy;
            if(visited.contains(key)) continue;
            
            //if the 'O' should be maintained, swicth if to 'D' here!
            board[xx][yy]='D';
            if(xx>0&&board[xx-1][yy]=='O'){
                x.add(xx-1);
                y.add(yy);
            }
            
            if(xx<m-1&&board[xx+1][yy]=='O'){
                x.add(xx+1);
                y.add(yy);
            }
            
            if(yy>0&&board[xx][yy-1]=='O'){
                x.add(xx);
                y.add(yy-1);
            }
            
            if(yy<n-1&&board[xx][yy+1]=='O'){
                x.add(xx);
                y.add(yy+1);
            }
            visited.add(key);
        }
        
        //assign the values to the board
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='D') board[i][j]='O';
                else if(board[i][j]=='O') board[i][j]='X';
            }
        }
    }
    
}
