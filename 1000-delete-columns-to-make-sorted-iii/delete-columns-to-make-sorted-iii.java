class Solution {
    String[] strs;
    int n,N;
    Integer[][] dp;
    
    public int minDeletionSize(String[] strs) {
        this.strs = strs;
        this.n = strs.length;
        this.N = strs[0].length();
        this.dp = new Integer[N][N];

        return N - solve(-1,0);
    }

    private int solve(int prev, int curr) {
        if(curr >= N) return 0;
        if(dp[prev+1][curr] != null) return dp[prev+1][curr];
        int skip = solve(prev,curr+1);
        int take = canTake(prev,curr) ? 1 + solve(curr,curr+1) : 0;

        return dp[prev+1][curr] = Math.max(take,skip);
    }



    private boolean canTake(int prev, int curr) {
        if(prev == -1) return true;

        for(int i=0; i<n; i++) {
            if(strs[i].charAt(prev) > strs[i].charAt(curr)) {
                return false;
            }
        }
        return true;
    }
}