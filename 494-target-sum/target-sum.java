class Solution {
    int result = 0;
    int n ;

    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;

        solve(nums,target,0);
        return result;
    }

    public void solve(int[] nums, int target,int start){
        if(target ==0 && start ==n){
            result++;
            return;
        }else if(start ==n){
            return;
        }

            
        solve(nums,target - nums[start],start+1);

        solve(nums,target + nums[start],start+1);
            
        
    }
}