class Solution {
    int MOD = 1_000_000_007;
    int m, n;
    long dp[][][];
   
    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new long[m][n][2];

        for(long[][] mat : dp) {
            for(long[] row : mat) {
                Arrays.fill(row,Integer.MAX_VALUE);
            }
        }

        long min[] = solve(grid, 0,0);
         
        return min[1] < 0 ? -1 : (int) (min[1] % MOD);
    }

    public long[] solve(int[][] grid, int i, int j) {
        if(i==m-1 && j== n-1) return new long [] {grid[i][j],grid[i][j]};

        if(dp[i][j][0] != Integer.MAX_VALUE) return dp[i][j];
    
        // right 
        long min = Integer.MAX_VALUE;
        long max =  Integer.MIN_VALUE;

        if(j+1 < n) {
            long sol[] = solve(grid, i, j+1);
            for(int k=0; k<2; k++) {
                min = Math.min(min, grid[i][j] * sol[k]);
                max = Math.max(max, grid[i][j] * sol[k]);
            }
        }

        // down 
        if(i+1 < m ) {
            long sol[] = solve(grid, i+1, j);
            for(int k=0; k<2; k++) {
                min = Math.min(min, grid[i][j] * sol[k]);
                max = Math.max(max, grid[i][j] * sol[k]);
            }
        }

        dp[i][j][0] = min;
        dp[i][j][1] = max;
        return dp[i][j];
    }
}