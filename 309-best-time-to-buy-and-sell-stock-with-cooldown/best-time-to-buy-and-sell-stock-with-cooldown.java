class Solution {
    int n;
    int[][] dp;
    public int maxProfit(int[] prices) {
        this.n = prices.length;
        dp = new int[n][2];

        for(int[] row : dp) Arrays.fill(row,-1);
        return solve(prices,0,0);
    }


    public int solve(int[] prices,int currDay, int bought) {
        if(currDay >= n) return 0;

        if(dp[currDay][bought] != -1) return dp[currDay][bought];

        int buy = 0, sell = 0, skip = 0;
        if(bought == 1) {
            sell = prices[currDay] + solve(prices,currDay + 2, 0);
        }else {
            buy = -prices[currDay] + solve(prices,currDay + 1, 1);
        }

        skip = solve(prices,currDay + 1, bought);

        return dp[currDay][bought] = Math.max(skip, Math.max(sell, buy));
    }
}