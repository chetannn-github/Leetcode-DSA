class Solution {
    int n;
    int dp[];
    public boolean canJump(int[] nums) {
        n = nums.length;
        dp = new int[n];
        Arrays.fill(dp,-1);

        return solve(nums,0) == 1 ? true : false;
    }

    public int solve(int[] nums, int start){
        if(start == n-1){
            return 1;
        }
        if(start>n-1){
            return 0;
        }

        if(dp[start]!= -1){
            return dp[start];
        }

        int jumps = nums[start];
        int isReached = 0;

        for(int i=1; i<=jumps; i++){
            isReached |= solve(nums, start+i);
            if(isReached ==1){
                break;
            }
        }

        return dp[start] =  isReached;
    }
}