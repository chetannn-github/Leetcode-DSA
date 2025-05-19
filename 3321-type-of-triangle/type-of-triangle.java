class Solution {
    public String triangleType(int[] nums) {
        if(nums[0] == nums[1] && nums[1] == nums[2]) return new String("equilateral");
        else if(nums[0] + nums[1] <= nums[2] || nums[0] + nums[2] <= nums[1]|| nums[1] + nums[2] <= nums[0] )return new String("none");
        else if(nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) return new String("isosceles");
        return new String("scalene");
    }
}