class Solution {
    int n;
    int MOD = 1_000_000_007;
    Integer[][] dp;
    public int numWays(int steps, int arrLength) {
        this.n = arrLength;
        this.dp = new Integer[steps+1][steps+1];
        return solve(0,steps);
    }

    private int solve(int currIdx, int stepsLeft) {
        if(currIdx < 0 || currIdx >= n) return 0;
        if(stepsLeft == 0) return currIdx == 0 ? 1 : 0;
        if(dp[currIdx][stepsLeft] != null) return dp[currIdx][stepsLeft];

        int left = solve(currIdx-1, stepsLeft-1);
        int stay = solve(currIdx, stepsLeft-1);
        int right = solve(currIdx+1, stepsLeft-1);

        return dp[currIdx][stepsLeft] = ((left + stay ) % MOD + right) % MOD;
    }
}