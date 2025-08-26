class Solution {
    int N;
    int[][] dp;
    int totalSum = 0;
    public boolean canPartition(int[] nums) {
        N = nums.length;
        
        for(int num : nums) totalSum += num;
        dp = new int[N][2 * totalSum + 1];

        for(int[] row : dp) Arrays.fill(row,-1);

        return solve(nums,0,0);
    }


    public boolean solve(int[] nums, int currIdx, int sum) {
        if(currIdx == N) return sum == 0;
        if(dp[currIdx][sum + totalSum] != -1) return dp[currIdx][sum + totalSum] == 1;

        boolean result = false;
        result = result || solve(nums,currIdx+1, sum + nums[currIdx]);
        result = result || solve(nums,currIdx+1, sum - nums[currIdx]);

        dp[currIdx][sum + totalSum] =  result ? 1 : 0;
        return result;
    }
}