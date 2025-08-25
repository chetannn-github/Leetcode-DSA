class Solution {
    int N;
    long[][] dp;
    public int minSteps(int n) {
        if(n == 1) return 0;
        N = n;
        dp = new long[n+1][n+1];
        for(long[] row : dp) Arrays.fill(row,-1);

        return 1 + (int) solve(1,1);
    }

    public long solve(int curr, int copied) {
        if (curr == N) return 0;
        if (curr > N) return Integer.MAX_VALUE;
        if(dp[curr][copied] != -1) return dp[curr][copied];

        long copy = Integer.MAX_VALUE, paste = Integer.MAX_VALUE;

        if(curr != copied) copy = 1 + solve(curr, curr);
        if(curr + copied <= N) paste = 1 + solve(curr + copied, copied);

        return dp[curr][copied] = Math.min(copy, paste);
    }
}