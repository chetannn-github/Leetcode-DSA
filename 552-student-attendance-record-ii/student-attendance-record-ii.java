class Solution {
    int MOD = 1_000_000_007;
    Integer[][][] dp;
    public int checkRecord(int n) {
        this.dp = new Integer[n+1][3][2];
        return solve(n,0,0);        
    }

    private int solve(int n, int lateCount, int absentCount) {
        if(absentCount == 2) return 0;
        if(lateCount == 3) return 0;
        if(n == 0) return 1;
        if(dp[n][lateCount][absentCount] != null) return dp[n][lateCount][absentCount];

        int absent = solve(n-1,0,absentCount+1);
        int late = solve(n-1,lateCount+1, absentCount);
        int present = solve(n-1,0,absentCount);

        return dp[n][lateCount][absentCount] = ((absent + late) % MOD + present) % MOD;
    }
}