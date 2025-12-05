class Solution {
    public int countPartitions(int[] nums) {
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        int prefixSum = 0;
        int result = 0;
        for(int i=0; i<nums.length-1; i++) {
            prefixSum += nums[i];
            result += 1 - (Math.abs(2 * prefixSum - totalSum) & 1) ;
        }

        return result;
    }
}