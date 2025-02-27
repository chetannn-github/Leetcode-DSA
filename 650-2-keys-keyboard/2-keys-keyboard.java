class Solution {
    long[][] dp;
    public int minSteps(int n) {
        dp = new long[n+1][n+1];
        for(long[] row : dp){
            Arrays.fill(row,-1);
        }
        return (int) solve(n-1,0,n);
    }


    public long solve(int req, int copied, int n){
        if(req==0){
            return 0;
        }

        if(req<0){
            return Integer.MAX_VALUE;
        }
        if(dp[req][copied] != -1){
            return dp[req][copied];
        }

    // two ops are possible each time either copy or paste(if copy earlier) 
        long copy = Integer.MAX_VALUE;
        long paste = Integer.MAX_VALUE;

        
        if(copied != n - req && n-req <= req){
            copy = 1 + solve(req, n - req , n);
        }
        
        if(copied != 0){
            paste = 1 + solve(req-copied, copied, n);
        }

        return dp[req][copied] = Math.min(copy,paste);
        
    }
}