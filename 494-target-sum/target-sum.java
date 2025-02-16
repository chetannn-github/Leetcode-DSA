class Solution {
    int n ;

    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        return solve(nums,target,0);
    }

    public int  solve(int[] nums, int target,int start){
        if(target ==0 && start ==n){
            return 1;
        }else if(start ==n){
            return 0;
        }            
       return  solve(nums,target - nums[start],start+1) + solve(nums,target + nums[start],start+1);
    }
}