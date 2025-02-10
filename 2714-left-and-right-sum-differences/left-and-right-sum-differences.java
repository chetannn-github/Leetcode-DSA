class Solution {
    public int[] leftRightDifference(int[] nums) {
        int  lsum= 0;
        int rsum =0;
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        for (int i =0; i<nums.length;i++){
            leftSum[i] = lsum;
            lsum+= nums[i];
            
            rightSum[nums.length-1-i] = rsum;
            rsum+= nums[nums.length-1-i];
        }
        for (int i =0; i<nums.length;i++){
            leftSum[i] = Math.abs(leftSum[i]-rightSum[i]);
        }
        return leftSum;

        
    }
}