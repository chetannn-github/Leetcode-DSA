class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i=0; i<n; i++){
            totalSum += nums[i];
        }
        int ans[] = new int[n] ; 
        int preSum = 0;
        for(int i=0; i<n; i++){
            int leftSum = nums[i] * i - preSum;
            int rightSum = totalSum - preSum - nums[i] - nums[i]*(n-1-i);
            
            ans[i] = rightSum + leftSum;
            preSum += nums[i];
        }
        return ans;
    }
}