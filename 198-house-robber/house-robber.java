class Solution {
    int[] dp ;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        
        return solve(nums,0) ;
    }

    public int solve(int[] nums, int start){
        if(start > nums.length-1){
            return 0;
        }
        if(dp[start]==-1){
            int option1 = nums[start] + solve(nums, start+2);
            int option2 =  solve(nums, start+1);
            dp[start] = Math.max(option1, option2);
        }
        
        return dp[start];

    }
}