class Solution {
    int n;
    int[][] dp;
    public int change(int amount, int[] coins) {
        n = coins.length;
        dp = new int[amount+1][n+1];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(amount,coins,0);

    }

    public int solve(int amount, int[] coins,int start){
        if(amount==0){
            return 1;
        }

        if(amount <0){
            return 0;
        }

        if(dp[amount][start]!=-1){
            return dp[amount][start];
        }

        int ways = 0;
        for(int i=start; i<n; i++){
            ways += solve(amount-coins[i] , coins,i);
        }

        return dp[amount][start] = ways;


        
    }
}