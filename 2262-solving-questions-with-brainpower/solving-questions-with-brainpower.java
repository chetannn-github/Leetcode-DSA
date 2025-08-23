class Solution {
    int n;
    long[] dp;
    public long mostPoints(int[][] questions) {
        n = questions.length;
        dp = new long[n];
        Arrays.fill(dp,-1);
        return solve(questions,0);
    }


    public long solve(int[][] questions, int currIdx) {
        if(currIdx >= n) return 0L;
        if(dp[currIdx] != -1) return dp[currIdx];

        long doit = questions[currIdx][0] + solve(questions,currIdx + questions[currIdx][1] + 1);
        long skip = solve(questions,currIdx + 1);

        return dp[currIdx] = Math.max(doit, skip);
    }
}