class Solution {
    int[][][] dp;
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new int[n][n][2];

        for(int[][] grid : dp) {
            for(int[] row : grid) {
                Arrays.fill(row,-1);
            }
        }
        return solve(nums,0,n-1, 1) >=0 ;
    }

    public int solve(int[] nums, int left, int right, int me) {
        if(left > right) return 0;
        if(dp[left][right][me] != -1) return dp[left][right][me];

        
        int opt1 = nums[left] - solve(nums,left+1, right, 1-me);
        int opt2 = nums[right] - solve(nums,left, right-1, 1-me);

        return dp[left][right][me] = Math.max(opt1, opt2);
    }
}