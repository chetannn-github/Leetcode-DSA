class Solution {
    int n;
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        n = prices.length;
        dp = new int[n][2];

        for(int[] row : dp) Arrays.fill(row, -1);

        return solve(prices,fee,0,0);
    }

    public int solve(int[] prices, int fee, int currIdx, int bought) {
        if(currIdx >= n) return 0;
        if(dp[currIdx][bought] != -1) return dp[currIdx][bought];

        int buy = 0, sell = 0, skip = 0;
        if(bought == 1) {
            sell = prices[currIdx] + solve(prices, fee, currIdx + 1, 0);
            skip = solve(prices, fee, currIdx +1, 1);
        } else {
            buy = -prices[currIdx] - fee + solve(prices,fee,currIdx +1, 1);
            skip = solve(prices, fee, currIdx +1, 0);
        }

        return dp[currIdx][bought] = Math.max(buy, Math.max(skip, sell));

    }
}