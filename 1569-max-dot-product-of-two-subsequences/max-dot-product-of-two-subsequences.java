class Solution {
    int[] nums1, nums2;
    int N,M;
    int INVALID = Integer.MIN_VALUE;
    int[][][] dp;
    int NOT_CACHED = Integer.MIN_VALUE;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        this.N = nums1.length;
        this.M = nums2.length;
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.dp = new int[N][M][2];

        for(int[][] grid : dp) {
            for(int[] row : grid) Arrays.fill(row,NOT_CACHED);
        }

        return solve(0,0,0);
    }

    private int solve(int x, int y, int taken) {
        if(x >= N || y >= M) return taken == 1 ? 0 : INVALID;
        if(dp[x][y][taken] != NOT_CACHED) return dp[x][y][taken];

        int take = nums1[x] * nums2[y] + solve(x+1, y+1,1);
        int opt1 = solve(x+1,y,taken);
        int opt2 = solve(x,y+1, taken);
        int opt3 = solve(x+1,y+1, taken);

        return dp[x][y][taken] = Math.max(Math.max(take,opt1), Math.max(opt2, opt3));
    }
}