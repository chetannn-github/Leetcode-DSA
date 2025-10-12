class Solution {
    int rows, cols;
    private static int dirns[][] = {{1,0}, {0,1},{-1,0},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
    

        int maxArea = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea,calculateArea(i,j,grid));
                }
            }
        }
        return maxArea;
        
    }

    public int calculateArea(int x, int y, int[][] grid) {
        int area = 1;
        grid[x][y] = 0;

        for(int[] dirn : dirns) {
            int nx = x + dirn[0];
            int ny = y + dirn[1];

            if(nx >=0 && ny >=0 && nx < rows && ny < cols) {
                if(grid[nx][ny] == 1) {
                    area += calculateArea(nx,ny,grid);
                }
            }
        }

        return area;
    }

}