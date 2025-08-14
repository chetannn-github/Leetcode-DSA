class Solution {
    int[] dp;
    int n;
    public int rob(int[] nums) {
        n = nums.length;
        dp = new int[n];
        Arrays.fill(dp,-1);

        return solve(0,nums);
    }

    private int solve(int currHouse, int[] nums) {
        if(currHouse >= n) return 0;

        if(dp[currHouse] != -1) return dp[currHouse];

        int rob = nums[currHouse] + solve(currHouse + 2, nums);
        int notRob = solve(currHouse + 1, nums);

        return dp[currHouse] = 
        Math.max(rob,notRob);
    }
}