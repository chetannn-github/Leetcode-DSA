class Solution {
    int n;
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.sort(coins);
        Arrays.fill(dp,-1);
        this.n = coins.length;
        
        int result = solve(coins,amount);
        return result == Integer.MAX_VALUE ? - 1 : result;
    }

    public int solve(int[] coins, int currAmt) {
        if(currAmt == 0) return 0;
        if(dp[currAmt] != -1) return dp[currAmt];

        int result = Integer.MAX_VALUE;
        for(int i=0; i<n && coins[i] <= currAmt; i++) {
            int leftAmtResult = solve(coins,currAmt - coins[i]);
            if(leftAmtResult != Integer.MAX_VALUE) {
                int currResult  = 1 + leftAmtResult;
                result = Math.min(result, currResult);
            }

        }
        
        return dp[currAmt] = result;
    }
}