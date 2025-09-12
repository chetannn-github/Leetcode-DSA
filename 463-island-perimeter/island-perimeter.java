class Solution {
    int rows, cols;
    private static int dirns[][] = {{1,0}, {0,1},{-1,0},{0,-1}};

    public int islandPerimeter(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1) {
                    return dfs(i,j,grid);
                }
            }
        }

        return -1;
    }

    public int dfs(int x, int y, int[][] grid) {
        int ans = 0;

        ans += findPerimeter(x,y,grid);
        grid[x][y] = 3;


        for(int[] dirn : dirns) {
            int nx = x + dirn[0];
            int ny = y + dirn[1];

            if(nx >=0 && ny >=0 && nx < rows && ny < cols) {
                if(grid[nx][ny] == 1) {
                    ans += dfs(nx,ny,grid);
                }
            }
        }

        return ans;
    }


    public int findPerimeter(int x,int y, int[][] grid) {
        int perimeter = 4;

        if(y-1 >=0 && (grid[x][y-1] & 1) == 1) perimeter--;
        if(y+1 < cols && (grid[x][y+1] & 1) == 1) perimeter--;
        if(x+1 < rows && (grid[x+1][y] & 1) == 1) perimeter--;
        if(x-1 >=0 && (grid[x-1][y]& 1) == 1) perimeter--;

        return perimeter;
    }
}