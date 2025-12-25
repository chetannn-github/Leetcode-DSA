class Solution {
    int MOD = 1_000_000_007;
    int n;
    Integer[][] dp;
    public int countOrders(int n) {
        this.n = n;
        this.dp = new Integer[n+1][n+1];
        return solve(0,0);
    }

    private int solve(int totalPickup, int dLeft) {
        if(dLeft < 0 || totalPickup > n) return 0;
        if(totalPickup == n && dLeft ==0) return 1;
        
        if(dp[totalPickup][dLeft] != null) return dp[totalPickup][dLeft];

        long pickup = ((long) (n-totalPickup) * solve(totalPickup+1,dLeft+1)) % MOD;
        long delivery = ((long) dLeft * solve(totalPickup,dLeft-1)) % MOD;

        return dp[totalPickup][dLeft] = (int) ((pickup + delivery) % MOD);
    }
}