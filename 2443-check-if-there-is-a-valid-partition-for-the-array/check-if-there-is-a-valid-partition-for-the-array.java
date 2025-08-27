class Solution {
    int N;
    int[] dp;
    int NOT_VISITED_FLAG = -1;
    public boolean validPartition(int[] nums) {
        N = nums.length;
        dp = new int[N];
        Arrays.fill(dp,NOT_VISITED_FLAG);

        return solve(nums,0);
    }


    private boolean solve(int[] nums, int currIdx) {
        if(currIdx == N) return true;
        if(dp[currIdx] != NOT_VISITED_FLAG ) return dp[currIdx] == 1;

        boolean result = false;

        if(currIdx+1 < N && nums[currIdx] == nums[currIdx+1])
            result = result || solve(nums, currIdx+2);

        if(currIdx+2 < N && nums[currIdx] == nums[currIdx+1] && nums[currIdx+1] == nums[currIdx+2])
            result = result || solve(nums, currIdx+3);

        if(currIdx+2 < N && nums[currIdx+1] == nums[currIdx]+1 && nums[currIdx+2] == nums[currIdx]+2)
            result = result || solve(nums, currIdx+3);

        dp[currIdx] = result ? 1 : 0;
        return result;
}

}