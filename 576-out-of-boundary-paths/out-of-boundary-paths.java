class Solution {
    int MOD = 1_000_000_007;
    long[][][] dp;
    long NOT_VISITED_FLAG = -1;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new long[m][n][maxMove + 1];
        for(long[][] grid : dp) {
            for(long[] row : grid) Arrays.fill(row,NOT_VISITED_FLAG);
        }

        return (int) solve(m,n,maxMove,startRow,startColumn);
    }


    public long solve(int m, int n, int moves, int currRow, int currCol) {
        if(currRow < 0 || currRow == m || currCol < 0 || currCol == n) {
            return 1;
        }

        if(dp[currRow][currCol][moves] != NOT_VISITED_FLAG) return dp[currRow][currCol][moves];

        if(moves == 0) return 0;

        long opt1 = solve(m,n,moves-1,currRow + 1, currCol) % MOD;
        long opt2 = solve(m,n,moves-1,currRow, currCol + 1) % MOD;
        long opt3 = solve(m,n,moves-1,currRow - 1, currCol) % MOD;
        long opt4 = solve(m,n,moves-1,currRow, currCol - 1) % MOD;

        return dp[currRow][currCol][moves] = (opt1 + opt2 + opt3 + opt4 ) % MOD;
    }
}