class Solution {
    int[] nums;
    int  n;
    long INVALID = (long)-1e18;
    Long[][] dp;

    public long maximumTotalCost(int[] nums) {
        this.nums = nums;
        this.n = nums.length;

        dp = new Long[n + 1][2];
        return solve(0, 0);
    }
    
    private long solve(int currIdx, int oddIdx) {
        if(currIdx >= n) return 0;
        if(dp[currIdx][oddIdx] != null)return dp[currIdx][oddIdx];
        

        long result = INVALID;
        long multiplyFactor = ((oddIdx&1) == 0) ? 1 : -1;

        result = solve(currIdx + 1, 0) + nums[currIdx] * multiplyFactor;
        result = Math.max(result, solve(currIdx + 1, 1- oddIdx) + nums[currIdx] * multiplyFactor);
    
        return dp[currIdx][oddIdx] = result;
    }



}