class Solution {
    int[] dp;
    int n;
    public int maxSumAfterPartitioning(int[] nums, int k) {
        n = nums.length;
        dp = new int[n];

        Arrays.fill(dp,-1);
        return solve(nums,k,0);
    }

    public int solve(int[] nums,int k,int start){
        if(start>=n){
            return 0;
        }
        if(dp[start]!=-1){
            return dp[start];
        }
        int max = Integer.MIN_VALUE;
        int maxSum = 0;

        for(int i=start; i<n && i<start+k; i++){
            max = Math.max(nums[i],max);
            maxSum = Math.max(maxSum , max*(i-start+1) + solve(nums,k,i+1));     
        }

        return dp[start] = maxSum;
    }
}