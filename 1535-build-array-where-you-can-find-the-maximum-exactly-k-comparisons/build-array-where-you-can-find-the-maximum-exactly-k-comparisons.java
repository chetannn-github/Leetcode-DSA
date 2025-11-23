class Solution {
    int m,n,k;
    int MOD = 1_000_000_007;
    Integer[][][] dp;
    public int numOfArrays(int n, int m, int k) {
        this.m = m; this.k = k; this.n = n;
        this.dp = new Integer[n][k+1][m+1];

        return solve(0,0,0);
    }

    private int solve(int elements, int searchCost, int maxVal) {
        if(searchCost > k) return 0;
        if(elements == n) return searchCost == k ? 1 : 0;
        if(dp[elements][searchCost][maxVal] != null) return dp[elements][searchCost][maxVal];

        int result = 0;

        for(int i=1; i<=m; i++) {
            if(i>maxVal) {
                result += solve(elements+1, searchCost+1, i);
            }else result += solve(elements+1,searchCost,maxVal);

            result %= MOD;
        }

        return dp[elements][searchCost][maxVal] = result % MOD;
    }
}