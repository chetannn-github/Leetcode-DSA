class Solution {

    public int climbStairs(int n) { 
        int[] dp = new int[46];
        Arrays.fill(dp,-1);

        
        return solve(n,dp);
    }

    public int solve(int n,int[] dp){
        if(n==0 || n==1){
            return 1;
        }
        
        if(dp[n-1]==-1){
            dp[n-1] = solve(n-1,dp);
        } 
        if(dp[n-2]==-1){
            dp[n-2] = solve(n-2,dp);
        }

        return dp[n-1] + dp[n-2];
    }

}