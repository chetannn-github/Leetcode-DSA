class Solution {
    int n;
    int[] nums;
    Integer[] dp;
    public String stoneGameIII(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.dp = new Integer[n];
        int result = solve(0);
        
        return result > 0 ? "Alice" : (result < 0 ? "Bob" : "Tie");
    }

    private int solve(int currIdx) {
        if(currIdx >= n) return 0;
        if(dp[currIdx] != null) return dp[currIdx];

        int cumSum = 0;
        int result = Integer.MIN_VALUE;
        for(int i=currIdx; i<Math.min(n,currIdx+3); i++) {
            cumSum += nums[i];
            int currResult = cumSum - solve(i+1); 

            result = Math.max(result,currResult);
        }

        return dp[currIdx] = result;
    }
}