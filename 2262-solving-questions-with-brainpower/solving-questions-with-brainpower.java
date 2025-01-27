class Solution {
    int n;
    long[] dp;
    public long mostPoints(int[][] questions) {
        n = questions.length;
        dp = new long[n];
        Arrays.fill(dp,-1);
        return solve(questions,0);
    }

    public long solve(int[][] questions,int start){
        if(start>=n){
            return 0;
        }

        if(dp[start]!= -1){
            return dp[start];
        }

        long take = questions[start][0] + solve(questions,start+questions[start][1]+1);

        long skip = solve(questions,start+1);

        return dp[start] = Math.max(take,skip);
    }
}