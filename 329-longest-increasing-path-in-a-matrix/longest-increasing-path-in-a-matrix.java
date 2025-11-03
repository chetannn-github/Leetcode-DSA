class Solution {
    int m,n;
    int NOT_VISITED_FLAG = -1;
    int MOD = 1_000_000_007;
    private static int[][] dirns = {{0,1},{1,0},{-1,0},{0,-1}};
    int[][] dp;
    public int longestIncreasingPath(int[][] grid) {
       this.m = grid.length;
        this.n = grid[0].length;
        dp = new int[m][n];

        for(int i=0; i<m; i++) Arrays.fill(dp[i],NOT_VISITED_FLAG);

        int result = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                result = Math.max(result,dfs(grid,i,j));
            }
        }

        return result;
    }

    private int dfs(int[][] grid, int x, int y) {
        if(dp[x][y] != NOT_VISITED_FLAG) return dp[x][y];

        int result = 1;
        for(int[] dirn : dirns) {
            int nx = x + dirn[0], ny = y + dirn[1];
            if(nx<0 || ny<0 || nx>=m || ny>=n) continue;

            if(grid[nx][ny] < grid[x][y]) {
                result = Math.max(result,1+dfs(grid,nx,ny));
            }
        }

        return dp[x][y] = result;
    }
}