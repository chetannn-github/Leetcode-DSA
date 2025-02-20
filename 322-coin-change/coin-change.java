class Solution {
    
    int[] dp = new int[10001];
    public int coinChange(int[] coins, int amount) {
        Arrays.fill(dp,-1);
        int result = solve(coins, amount); 
        return result == Integer.MAX_VALUE ? -1 : result;
       
    }

    public int solve(int[] coins, int amount){
        if(amount==0){
            return 0; 
        }
        if(amount<0){
            return Integer.MAX_VALUE;
        }

        if(dp[amount] != -1){
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;

        for(int i=0; i<coins.length; i++){
            int coinsRequired = solve(coins, amount - coins[i]);

            if(coinsRequired != Integer.MAX_VALUE){
                min = Math.min(coinsRequired +1 , min);
            }
        }
       
        return dp[amount] = min;
    }
}


