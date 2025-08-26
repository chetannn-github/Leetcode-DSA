class Solution {
    int n;
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        dp = new int[target + 3001][n];
        for(int[] row : dp) Arrays.fill(row,-1);

        return solve(nums,target,0,0);
    }

    public int solve(int[] nums, int target, int currIdx, int currVal) {
        if(currVal == target && currIdx == n) return 1;
        if(currIdx == n) return 0;
        if(dp[currVal + 1000][currIdx] != -1) return dp[currVal + 1000][currIdx];

        int opt1 = solve(nums,target,currIdx + 1, currVal + nums[currIdx]);
        int opt2 = solve(nums,target,currIdx + 1, currVal - nums[currIdx]);

        return dp[currVal + 1000][currIdx] = opt1 + opt2;
    }
}