class Solution {
    int rows, cols;
    private static int dirns[][] = {{1,0}, {0,1},{-1,0},{0,-1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.rows = grid1.length;
        this.cols = grid1[0].length;
    
        int totalSubIslands = 0;
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid2[i][j] == 1) {
                    totalSubIslands += isSubIsland(i,j,grid1,grid2) ? 1 : 0;
                }
            }
        }

        return totalSubIslands;
    }


    public boolean isSubIsland(int x, int y, int[][] grid1,int[][] grid2) {
        boolean result = grid1[x][y] == 1;

        grid2[x][y] = 0;

        for(int[] dirn : dirns) {
            int nx = x + dirn[0];
            int ny = y + dirn[1];

            if(nx >=0 && ny >=0 && nx < rows && ny < cols) {
                if(grid2[nx][ny] == 1) {
                    if(!isSubIsland(nx,ny,grid1,grid2)){
                        result = false;
                    }
                }
            }
        }

        return result;
    }
}