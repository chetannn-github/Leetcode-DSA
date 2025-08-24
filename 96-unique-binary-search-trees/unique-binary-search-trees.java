class Solution {
    int[][] dp;
    int NOT_VISITED_FLAG = -1;
    public int numTrees(int N) {
        dp = new int[N+1][N+1];
        for(int[] row : dp ) Arrays.fill(row,NOT_VISITED_FLAG);

        return solve(1,N);
    }

    public int solve(int start, int end) {
        if(start >= end ) return 1;
        if(dp[start][end] != NOT_VISITED_FLAG) return dp[start][end];

        int result = 0;
        for(int i=start; i<=end; i++) {
            int leftPossible = solve(start, i-1);
            int rightPossible = solve(i+1, end);

            result += leftPossible * rightPossible;
        }

        return dp[start][end] = result;
    }
}