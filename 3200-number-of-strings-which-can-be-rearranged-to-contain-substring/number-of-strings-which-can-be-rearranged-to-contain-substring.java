class Solution {
    int MOD = 1_000_000_007;
    Integer[][][][] dp;
    public int stringCount(int n) {
        this.dp = new Integer[2][3][2][n+1];
        return  solve(0,0,0,n);
    }

    private int solve(int l, int e, int t, int n) {
        if(n == 0) return (l>0 && e>1 && t>0) ? 1 : 0;
        if(dp[l][e][t][n] != null) return dp[l][e][t][n];

        long takeL = solve(Math.min(1,l+1),e,t,n-1);
        long takeE = solve(l,Math.min(2,e+1),t,n-1);
        long takeT = solve(l,e,Math.min(1,t+1),n-1);
        long takeOther = (23L * solve(l,e,t,n-1)) % MOD;

        long totalResult = ((takeL + takeE) % MOD  + (takeT + takeOther) % MOD) % MOD;

        return dp[l][e][t][n] = (int) totalResult;
    }
}