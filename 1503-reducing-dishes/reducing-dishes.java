class Solution {
    int N;int[] arr;
    int[][] dp;
    int NOT_CACHED = Integer.MIN_VALUE;
    public int maxSatisfaction(int[] arr) {
        this.N = arr.length;
        Arrays.sort(arr);
        this.arr = arr;
        this.dp = new int[N][N+1];

        for(int[] row : dp) Arrays.fill(row,NOT_CACHED);
        return solve(0,1);
    }

    private int solve(int currIdx, int currTime) {
        if(currIdx >= N) return 0;
        if(dp[currIdx][currTime] != NOT_CACHED) return dp[currIdx][currTime];

        int take = arr[currIdx] * currTime + solve(currIdx+1, currTime+1);
        int skip = solve(currIdx+1, currTime);

        return dp[currIdx][currTime] = Math.max(take,skip);
    }
}