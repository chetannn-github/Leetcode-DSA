class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp,-1);
        int zero = solve(cost,0);
        int one = solve(cost,1);

        return Math.min(zero,one);

    }

    public int solve(int[] cost, int start){
        if(start==cost.length-1 || start==cost.length-2){
            return cost[start];
        }
        if(dp[start]==-1){
            int oneStep = cost[start] + solve(cost,start+1);
            int twoStep = cost[start] + solve(cost,start+2);
            dp[start] = Math.min(oneStep,twoStep);
        }
        

        return dp[start];

    }
}