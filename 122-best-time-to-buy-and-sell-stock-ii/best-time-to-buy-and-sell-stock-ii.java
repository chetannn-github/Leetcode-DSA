class Solution {
    int N;
    int[][] dp;
    int NOT_VISITED_FLAG = -1;
    public int maxProfit(int[] prices) {
        N = prices.length;
        dp = new int[N][2];
        for(int[] row : dp) Arrays.fill(row,NOT_VISITED_FLAG);
        
        return solve(prices,0,0);
    }

    public int solve(int[] prices, int currDay, int bought) {
        if(currDay >= N) return 0;
        if(dp[currDay][bought] != NOT_VISITED_FLAG) return dp[currDay][bought];

        int result = Integer.MIN_VALUE;
        if(bought == 1) {
            result = prices[currDay] + solve(prices,currDay + 1, 0);
        }else {
            result = -prices[currDay] + solve(prices,currDay + 1, 1);
        }

        int skip = solve(prices,currDay + 1, bought);

        return dp[currDay][bought] = Math.max(skip , result);
    }
}