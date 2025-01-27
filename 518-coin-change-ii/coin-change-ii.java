// class Solution {
//     int n;
//     int[][] dp;
//     public int change(int amount, int[] coins) {
//         n = coins.length;
//         dp = new int[n+1][amount+1];
//         Arrays.sort(coins);
//         for(int[] row : dp){
//             Arrays.fill(row,-1);
//         }
//         return solve(amount,coins,0);

//     }

//     public int solve(int amount, int[] coins,int start){
//         if(amount==0){
//             return 1;
//         }

//         if(amount <0){
//             return 0;
//         }

//         if(dp[start][amount]!=-1){
//             return dp[start][amount];
//         }

//         int ways = 0;
//         for(int i=start; i<n; i++){
//             if(amount-coins[i]<0){
//                 break;
//             }
//             ways += solve(amount-coins[i] , coins,i);
//         }

//         return dp[start][amount] = ways;


        
//     }
// }

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][5001];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return solve(0, amount, coins, dp);

    }
    private int solve(int start, int amount, int[] coins, int[][] dp) {
        if(amount == 0) {
            return 1;
        }
        if(start >= coins.length) {
            return 0;
        }
        if(dp[start][amount] != -1) {
            return dp[start][amount];
        }

        //skip 
        int skip = solve(start+1, amount, coins, dp);

        //take
        if(coins[start] <= amount) {
            int take = solve(start, amount-coins[start], coins, dp);
            skip += take;
        }
        return dp[start][amount] = skip;
    }
}