class Solution {
    int N;
    int[][][] dp;
    int NOT_VISITED_FLAG = -1;
    public int maxProfit(int[] prices) {
        N = prices.length;
        dp = new int[N][2][4];
        for(int[][] grid : dp) {
            for(int[] row : grid) {
                Arrays.fill(row,NOT_VISITED_FLAG);
            }
            
        }
        return solve(prices,0,0,0);
    }
    public int solve(int[] prices, int currDay, int bought, int transactions) {
        if(transactions > 3) return 0;
        if(currDay >= N) return 0;
        if(dp[currDay][bought][transactions] != NOT_VISITED_FLAG) return dp[currDay][bought][transactions];

        int result = Integer.MIN_VALUE;
        if(bought == 1) {
            result = prices[currDay] + solve(prices,currDay + 1, 0, transactions+1);
        }else {
            result = -prices[currDay] + solve(prices,currDay + 1, 1, transactions+1);
        }

        int skip = solve(prices,currDay + 1, bought, transactions);

        return dp[currDay][bought][transactions] = Math.max(skip , result);
    }
}