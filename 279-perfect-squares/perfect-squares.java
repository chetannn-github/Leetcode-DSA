class Solution {
    int[] dp;
    public int numSquares(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        int result = solve(n);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int solve( int target){
        
        if(target==0){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        if(dp[target]!= -1){
            return dp[target];
        }

        for(int i=(int)Math.sqrt(target); i>0; i--){
            int result = solve(target-i*i);
            min = Math.min(result+1,min);
        }
        
        return dp[target] = min;
    }
}