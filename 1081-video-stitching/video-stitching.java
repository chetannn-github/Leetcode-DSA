class Solution {
    int n;
    long[][] dp;
    public int videoStitching(int[][] clips, int time) {
        n = clips.length;
        dp = new long[n][101];

        for(long[] row : dp){
            Arrays.fill(row,-1);
        }

        Arrays.sort(clips,(a,b)-> a[0] - b[0]);
        int ans =(int) solve(clips,time,0,0);
        
        return ans == Integer.MAX_VALUE? -1: ans ;
    }

    public long solve(int[][] clips, int time, int start, int lastOne){
        if(lastOne>=time){
            return 0;
        }

        if(start>=n){
            return Integer.MAX_VALUE;
        }
        if(dp[start][lastOne]!= -1){
            return dp[start][lastOne];
        }
        long take = Integer.MAX_VALUE;

        if(clips[start][0] <= lastOne){
            take = 1 + solve(clips, time,start+1,Math.max(clips[start][1],lastOne));
        }
        
        long skip = solve(clips,time,start+1, lastOne);

        return dp[start][lastOne] = Math.min(take, skip);
    }
}