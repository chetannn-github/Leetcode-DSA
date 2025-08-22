class Solution {
    int n;
    int[][] dp;
    public int change(int amount, int[] coins) {
        this.n = coins.length;
        dp = new int[amount + 1][n];
        for(int[] row : dp) Arrays.fill(row,-1);

        Arrays.sort(coins);

        int result = solve(amount,coins,n-1);
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private int solve(int amt, int[] coins, int lastIdx) {
        if(amt == 0) return 1;

        if(dp[amt][lastIdx] != -1) return dp[amt][lastIdx];

        int result = 0;

        for(int i=0; i<=lastIdx && coins[i] <= amt; i++) {
            int nextResult = solve(amt - coins[i], coins,i);
            result += nextResult;
            
        }

        return dp[amt][lastIdx] = result;
    }
}