// great question of bit manipulationn!!!!!!!
class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length, cols = board[0].length;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int neighbours = calcNeighbours( board,rows, cols, i, j);

                if(board[i][j]==0 && neighbours ==3){
                    board[i][j]= 2; // 10 in binary
                }else if(board[i][j] == 1 && (neighbours == 2 || neighbours == 3)){
                    board[i][j]=3; // 11 in binary
                }
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                board[i][j] >>= 1;
            }
        }
        
    }

    public int calcNeighbours(int[][] board,int rows, int cols, int r, int c){
        int count = 0;
        for(int i = Math.max(0, r-1); i <= Math.min(r+1,rows-1); i++){
            for(int j = Math.max(0, c-1); j <= Math.min(c+1,cols-1); j++){
                if(i == r && j == c) continue;
                count += (board[i][j] & 1 );
            }
        }
        return count;
    }
}