class Solution {
    int mod = 1_000_000_007;
    long dp[][][];
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new long[m][n][maxMove+1];

        for(long[][] grid : dp){
            for(long[] row : grid){
                Arrays.fill(row,-1);
            }
        }

        return (int) solve(m,n,maxMove,startRow, startColumn);
    }

    public long solve(int m, int n, int moves, int startRow, int startColumn){
        if(startRow == -1 || startColumn == -1 || startRow == m || startColumn == n ){
            return 1;
        }

        if(dp[startRow][startColumn][moves]!= -1){
            return dp[startRow][startColumn][moves];
        }
        long ways = 0;
        if(moves>0){
            ways += solve(m,n,moves-1, startRow-1,startColumn);
            ways %= mod;
            ways += solve(m,n,moves-1, startRow+1,startColumn);
            ways %= mod;
            ways += solve(m,n,moves-1, startRow,startColumn+1);
            ways %= mod;
            ways += solve(m,n,moves-1, startRow,startColumn-1);
            ways %= mod;
        }

        return dp[startRow][startColumn][moves] = ways;
    }


}