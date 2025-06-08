class Solution {
    public int maxArea(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int maxWater  = 0;

        while(left<right){
            int water = Math.min(nums[left],nums[right]) * (right-left);
            maxWater = Math.max(maxWater,water);

            if(nums[left]>nums[right]) right--;
            else left++;
        } 
        return maxWater;
    }
}