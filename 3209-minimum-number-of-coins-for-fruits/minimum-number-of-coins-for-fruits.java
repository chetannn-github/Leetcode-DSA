class Solution {
    int n;
    int[] dp;
    public int minimumCoins(int[] prices) {
        n = prices.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        
        return solve(prices,0);
    }

    public int solve(int[] prices, int start){
        if(start>=n){
            return 0;
        }
        if(dp[start]!= -1){
            return dp[start];
        }
        int min = Integer.MAX_VALUE;

        for(int i = 1; i<=start+2; i++){
            min = Math.min(prices[start] + solve(prices, start + i),min);
        }

        return dp[start] = min;

    }
}