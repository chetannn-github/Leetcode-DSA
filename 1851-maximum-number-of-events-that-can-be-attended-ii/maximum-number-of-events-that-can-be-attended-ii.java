class Solution {
    int n;
    int NOT_CACHED = -2;
    int[][] dp;
    public int maxValue(int[][] events, int k) {
        n = events.length;
        dp = new int[n][k+1];
        for(int i=0; i<n; i++) events[i][0]--;
        Arrays.sort(events,(a,b)->(a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]));

        for(int[] row : dp) Arrays.fill(row,NOT_CACHED);
        return solve(events,0,k);
    }

    private int solve(int[][] events,int currIdx,int k) {
        if(currIdx >= n || k == 0) return 0;
        if(dp[currIdx][k] != NOT_CACHED) return dp[currIdx][k];

        int take = events[currIdx][2] + solve(events,bs(events,currIdx),k-1);
        int skip = solve(events,currIdx+1,k);

        return dp[currIdx][k] = Math.max(take,skip);
    }

    private int bs(int[][] events,int currIdx) {
        int start = currIdx + 1, end = n-1;
        int target = events[currIdx][1];
        int result = n;

        while(start <= end) {
            int mid = start + ((end-start)>>1);

            if(events[mid][0] >= target) {
                result = mid;
                end = mid -1;
            }else start = mid+1;
        }
        return result;
    }
}