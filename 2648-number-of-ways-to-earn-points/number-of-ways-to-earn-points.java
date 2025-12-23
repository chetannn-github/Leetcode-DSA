class Solution {
    int target,n;
    int[][] types;
    int MOD = 1_000_000_007;
    Integer[][] dp;
    public int waysToReachTarget(int target, int[][] types) {
        this.target = target;
        this.types = types;
        this.n = types.length;
        this.dp = new Integer[n][target];
        return solve(0,0);
    }


    private int solve(int currIdx, int currScore) {
        if(currScore == target) return 1;
        if(currScore > target || currIdx == n) return 0;
        if(dp[currIdx][currScore] != null) return dp[currIdx][currScore];

        int currQs = types[currIdx][0];
        int marks = types[currIdx][1];
        
        long result = 0L;
        for(int i=0; i<=currQs; i++) {
            int nextScore = currScore + i * marks;
            if(nextScore > target) break;
            result = (result + solve(currIdx+1, nextScore)) % MOD;
        }

        return dp[currIdx][currScore] = (int) (result % MOD);
    
    }
}