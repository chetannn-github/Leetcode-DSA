class Solution {
    int rows,cols;
    private static int[][] dirns = {{-1,0},{1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        int totalIslands = 0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == '1') {
                    dfs(new Pair(i,j),grid);
                    totalIslands++;
                }
            }
        }
        
        
        return totalIslands;
    }


    public void dfs(Pair curr, char[][] grid) {
        int x = curr.x, y = curr.y;
        grid[x][y] = '0';

        for(int[] dirn : dirns) {
            int nx = x + dirn[0];
            int ny = y + dirn[1];

            if(nx >= 0 && ny >= 0 && nx < rows && ny < cols) {
                if(grid[nx][ny] == '1') {
                    dfs(new Pair(nx,ny),grid);
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