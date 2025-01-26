class Solution {
    int n;
    long dp[];
    public int jump(int[] nums) {
        n = nums.length;
        dp = new long[n];
        Arrays.fill(dp,-1);

        return (int) solve(nums,0);
    }

    public long solve(int[] nums, int start){
        if(start == n-1){
            return 0;
        }
        if(start>n-1){
            return Integer.MAX_VALUE;
        }

        if(dp[start]!= -1){
            return dp[start];
        }

        int jumps = nums[start];
        long min = Integer.MAX_VALUE;

        for(int i=1; i<=jumps; i++){
            min = Math.min(1+ solve(nums, start+i), min);
            
        }

        return dp[start] = min;
    }
}