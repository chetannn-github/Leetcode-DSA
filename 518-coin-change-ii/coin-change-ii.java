class Solution {
    int n;
    int[][] dp;
    public int change(int amount, int[] coins) {
        n = coins.length;
        dp = new int[n+1][amount+1];

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

        if(dp[start][amount]!=-1){
            return dp[start][amount];
        }

        int ways = 0;
        for(int i=start; i<n; i++){
            if(amount-coins[i]<0){
                continue;
            }
            ways += solve(amount-coins[i] , coins,i);
        }

        return dp[start][amount] = ways;


        
    }
}