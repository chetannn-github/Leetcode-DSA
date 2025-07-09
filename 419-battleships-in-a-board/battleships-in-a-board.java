class Solution {
    int rows,cols;
    private static int[][] dirns = {{-1,0},{1,0},{0,1},{0,-1}};
    public int countBattleships(char[][] board) {
        this.rows = board.length;
        this.cols = board[0].length;
        int totalBattleships = 0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(board[i][j] == 'X') {
                    dfs(new Pair(i,j),board);
                    totalBattleships++;
                }
            }
        }
        
        
        return totalBattleships;
    }


    public void dfs(Pair curr, char[][] board) {
        int x = curr.x, y = curr.y;
        board[x][y] = '.';

        for(int[] dirn : dirns) {
            int nx = x + dirn[0];
            int ny = y + dirn[1];

            if(nx >= 0 && ny >= 0 && nx < rows && ny < cols) {
                if(board[nx][ny] == 'X') {
                    dfs(new Pair(nx,ny),board);
                }
            }
        }        
    }

}


class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}