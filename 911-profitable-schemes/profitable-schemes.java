class Solution {
    int n, minProfit;
    int[] group, profit;
    int MOD = 1_000_000_007;
    Integer[][][] dp;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        this.n = n;
        this.minProfit = minProfit;
        this.group = group;
        this.profit = profit;
        this.dp = new Integer[group.length][minProfit+1][n+1];

        return solve(0,0,0);
    }

    private int solve(int currIdx, int totalProfit, int members) {
        if(members > n) return 0;
        if(currIdx == group.length) return totalProfit >= minProfit ? 1 : 0;
        if(dp[currIdx][totalProfit][members] != null) return dp[currIdx][totalProfit][members];

        int take = solve(currIdx+1, Math.min(minProfit, profit[currIdx] + totalProfit),members + group[currIdx]);
        int skip = solve(currIdx+1, totalProfit, members);

        return dp[currIdx][totalProfit][members] = (take + skip) % MOD;
    }
}