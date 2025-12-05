class Solution {
    int[][] dp ;
    int totalSlices ;
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        this.totalSlices = n/3;
        dp = new int[n][n/3 + 1];
        
        for(int[] row : dp) Arrays.fill(row,-1);
        int opt1 = solve(slices,0,n-2,0);

        for(int[] row : dp) Arrays.fill(row,-1);
        int opt2 = solve(slices,1,n-1,0);
        
        return Math.max(opt1,opt2);
    }

    public int solve(int[] slices, int start, int end, int slicesTaken){
        if(slicesTaken == totalSlices) return 0;
        if(start > end){
            return 0;
        }
        if(dp[start][slicesTaken]==-1){
            int rob = slices[start] + solve(slices, start+2,end,slicesTaken+1);
            int notRob =  solve(slices, start+1,end,slicesTaken);
            dp[start][slicesTaken] = Math.max(rob, notRob);
        }
        
        return dp[start][slicesTaken];

    }
}