class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int opt1 = nums[nums.length-1] - nums[2]; 
        int opt2 = nums[nums.length-3] - nums[0];
        int opt3 = nums[nums.length-2] - nums[1];
        
        return Math.min(Math.min(opt1, opt2),opt3);
    }
}