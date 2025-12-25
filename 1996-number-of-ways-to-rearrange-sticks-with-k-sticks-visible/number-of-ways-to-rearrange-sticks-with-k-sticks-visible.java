class Solution {
    int MOD = 1_000_000_007;
    Integer[][] dp;
    public int rearrangeSticks(int n, int k) {
        this.dp = new Integer[n+1][k+1];
        return solve(n,k);
    }

    private int solve(int n, int k) {
        if(n==k) return 1;
        if(n == 0 || k == 0) return 0;
        if(dp[n][k] != null) return dp[n][k];

        long putLargestAtEnd = solve(n-1,k-1);
        long putSmallerOnesAtEnd = ((long) (n-1) * solve(n-1,k)) % MOD;

        return dp[n][k] = (int) ((putLargestAtEnd + putSmallerOnesAtEnd) % MOD);
    }
}