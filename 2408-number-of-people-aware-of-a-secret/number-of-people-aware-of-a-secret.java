class Solution {
    int n, delay, forget;
    int MOD = 1_000_000_007;
    int[] dp;
    int NOT_VISITED_FLAG = -1;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        this.n = n;
        this.delay = delay;
        this.forget = forget;

        dp = new int[n+1];
        Arrays.fill(dp,NOT_VISITED_FLAG);

        return  solve(1);
    }


    private int solve(int currDay) {
        if(dp[currDay] != NOT_VISITED_FLAG) return dp[currDay];
        if(currDay + delay > n) return 1;
        
        int start = currDay + delay;
        int end = Math.min(currDay + forget-1, n);
        int result = currDay + forget > n ? 1 : 0;

        for(int i=start; i<=end; i++) {
            result += (solve(i) % MOD);
            result %= MOD;
        }

        return dp[currDay] = result % MOD;
    }
}