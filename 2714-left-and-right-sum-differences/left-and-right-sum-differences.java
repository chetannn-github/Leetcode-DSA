class Solution {
    public int[] leftRightDifference(int[] nums) {
        int lsum = 0;
        int rsum = 0;
        int n = nums.length;

        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        for (int i =0; i<n;i++){
            leftSum[i] = lsum;
            lsum += nums[i];
            
            rightSum[n-1-i] = rsum;
            rsum += nums[n-1-i];
        }
        for (int i = 0; i<n; i++){
            leftSum[i] = Math.abs(leftSum[i]-rightSum[i]);
        }
        return leftSum;
    }
}