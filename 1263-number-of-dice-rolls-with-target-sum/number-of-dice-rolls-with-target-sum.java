class Solution {
    long[][] dp;
    int MOD = 1_000_000_007;
    public int numRollsToTarget(int dices, int faces, int target) {
        dp = new long[dices + 1][target + 1];
        for(long[] row : dp) Arrays.fill(row,-1);

        return (int) (solve(dices,faces,target) % MOD);
    }


    public long solve(int dices, int faces, int target) {
        if(dices == 0 && target == 0) return 1;
        if(dp[dices][target] != -1) return dp[dices][target];


        long result = 0;
        for(int i=1; i<=faces && target - i >= 0 && dices - 1 >= 0; i++) {
            result += (solve(dices-1,faces,target-i)) % MOD;
            
        }

        return dp[dices][target] = result % MOD;
    }
}