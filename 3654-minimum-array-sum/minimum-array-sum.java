class Solution {
    int[][][] dp;
    int NOT_VISITED_FLAG = -1;
    int N;
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        N = nums.length;
        dp = new int[N][op1 + 1][op2 + 1];

        for(int[][] grid : dp) {
            for(int[] row : grid ) Arrays.fill(row, NOT_VISITED_FLAG);
        }
        return solve(nums,k,op1,op2, 0);
    }

    public int solve(int[] nums,int k,int op1,int op2, int i) {
        if(i >= N) return 0;

        if(dp[i][op1][op2] != NOT_VISITED_FLAG) return dp[i][op1][op2];

        int half = (nums[i] + 1) / 2;
        int result = Integer.MAX_VALUE;
        if(op1 > 0) {
            result = half + solve(nums,k,op1-1,op2, i+1);
        }
        if(op2 > 0 && nums[i] - k >= 0) {
            result = Math.min(result, nums[i] - k + solve(nums,k,op1,op2 - 1, i+1));
        } 
        if(op1 > 0 && op2 > 0 && half - k >= 0) {
            result = Math.min(result,half - k + solve(nums,k,op1 - 1,op2 - 1, i+1));
        }
        if(op1 > 0 && op2 > 0 && nums[i] - k >= 0) {
            result = Math.min(result,(nums[i] - k + 1) / 2 + solve(nums,k,op1 - 1,op2 - 1, i+1));
        }

        result = Math.min(result, nums[i] + solve(nums,k,op1,op2, i+1));
        return dp[i][op1][op2] = result;
    }
}