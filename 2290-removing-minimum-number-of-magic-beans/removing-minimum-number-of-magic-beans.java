class Solution {
    public long minimumRemoval(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        long totalSum = 0;
        for(int i=0; i<n; i++){
            totalSum += nums[i];
        }
        long preSum = 0;
        long min = Long.MAX_VALUE;

        for(int i=0; i<n; i++){
            long leftSum = preSum;
            long rightSum =  totalSum - preSum - nums[i] -(long) nums[i]*(n-1-i);
            long sum = leftSum + rightSum;

            if(min>sum) min = sum;

            preSum += nums[i];
        }
        return min;
    }
}