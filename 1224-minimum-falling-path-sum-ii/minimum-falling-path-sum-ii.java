class Solution {
    int n;
    int[][] grid;
    int[][] dp;
    public int minFallingPathSum(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        this.dp = new int[n][n];
        int result = Integer.MAX_VALUE;

        for(int[] row : dp) Arrays.fill(row,Integer.MAX_VALUE);

        for(int col=0; col<n; col++) {
            result = Math.min(result,grid[0][col] + solve(0,col));
        }

        return result;
    }

    private int solve(int x, int y) {
        if(x >= n-1) return 0;
        if(dp[x][y] != Integer.MAX_VALUE) return dp[x][y];

        int result = Integer.MAX_VALUE;
        for(int col=0; col<n; col++) {
            if(col == y) continue;
            result = Math.min(result, grid[x+1][col] + solve(x+1,col));
        }

        return dp[x][y] = result;
    }
}