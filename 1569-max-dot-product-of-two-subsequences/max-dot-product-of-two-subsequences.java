class Solution {
    int[] nums1, nums2;
    int N,M;
    int INVALID = Integer.MIN_VALUE;
    int[][] dp;
    int NOT_CACHED = Integer.MIN_VALUE;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        this.N = nums1.length;
        this.M = nums2.length;
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.dp = new int[N][M];

        for(int[] row : dp) Arrays.fill(row,NOT_CACHED);
        return solve(0,0);
    }

    private int solve(int x, int y) {
        if(x >= N || y >= M) return INVALID;
        if(dp[x][y] != NOT_CACHED) return dp[x][y];

        int val = nums1[x] * nums2[y];

        int takeBoth = val + Math.max(0,solve(x+1, y+1));
        int takeX = solve(x+1,y);
        int takeY = solve(x,y+1);
        
        return dp[x][y] = Math.max(Math.max(takeBoth,takeX), Math.max(val,takeY));
    }
}