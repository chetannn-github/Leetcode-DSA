class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int totalFlipCount = 0;
        
        for(int i=0; i<n; i++) {
            if(nums[i] == totalFlipCount %2) {
                totalFlipCount++;
            }
        }

        return totalFlipCount;
    }
}