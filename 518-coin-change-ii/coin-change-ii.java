class Solution {
    int n;
    int[][] dp;
    public int change(int amount, int[] coins) {
        n = coins.length;
        dp = new int[n+1][amount+1];
        Arrays.sort(coins);
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(amount,coins,0);

    }

    public int solve(int amount, int[] coins,int start){
        if(amount==0){
            return 1;
        }


        if(dp[start][amount]!=-1){
            return dp[start][amount];
        }

        int ways = 0;
        for(int i=start; i<n; i++){
            if(amount-coins[i]<0){
                break;
            }
            ways += solve(amount-coins[i] , coins,i);
        }

        return dp[start][amount] = ways;

    }
}

// class Solution {
//     int n;
//     public int change(int amount, int[] coins) {
//         n = coins.length;
//         int[] dp = new int[amount +1];
//         Arrays.sort(coins);
//         Arrays.fill(dp, -1);
        
//         return solve( amount, coins, dp,0);

//     }
//     // private int solve(int start, int amount, int[] coins, int[][] dp) {
//     //     if(amount == 0) {
//     //         return 1;
//     //     }
//     //     if(start >= coins.length) {
//     //         return 0;
//     //     }
//     //     if(dp[start][amount] != -1) {
//     //         return dp[start][amount];
//     //     }

//     //     //skip 
//     //     int skip = solve(start+1, amount, coins, dp);

//     //     //take
//     //     if(coins[start] <= amount) {
//     //         int take = solve(start, amount-coins[start], coins, dp);
//     //         skip += take;
//     //     }
//     //     return dp[start][amount] = skip;
//     // }


//     public int solve(int amount,int[] coins, int[]dp, int start){
//         if(amount == 0){
//             return 1;
//         }

//         int ans = 0;
//         for(int i=start; i<n; i++){
//             if(amount >= coins[i]){
//                 ans += solve(amount - coins[i], coins,dp, i);
//             }
//         }

//         return ans;
//     }
// }