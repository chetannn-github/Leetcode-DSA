class Solution {
    int[][] dirns = {{0,1},{0,-1},{1,0},{-1,0}};
    int rows, cols;
    public int findMaxFish(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        int maxSum = 0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] != 0) {
                    maxSum = Math.max(dfs(grid,i,j),maxSum);
                }
            }
        }

        return maxSum;
    }

    public int dfs(int[][] grid, int i, int j) {
        int sum = grid[i][j];
        grid[i][j] = 0;
        
        for(int[] dirn : dirns) {
            int nx = i + dirn[0];
            int ny = j + dirn[1];
            boolean isInBound = nx < rows && nx >= 0 && ny < cols && ny >=0;
            
            if(isInBound && grid[nx][ny] != 0) {
                sum += dfs(grid,nx,ny);
            }
        }

        return sum;
    }
}