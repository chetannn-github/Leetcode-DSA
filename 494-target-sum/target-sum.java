class Solution {
    int n ;
    HashMap<String,Integer> dp;

    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        dp = new HashMap<>();
        return solve(nums,target,0);
    }

    public int  solve(int[] nums, int target,int start){
        if(target ==0 && start ==n){
            return 1;
        }else if(start ==n){
            return 0;
        }  

        String key = target + "-->" + start;

        if(dp.containsKey(key)){
            return dp.get(key);
        }
        int plus = solve(nums,target - nums[start],start+1);
        int minus = solve(nums,target + nums[start],start+1);  
        dp.put(key,plus+minus);    

        return plus + minus;
    }
}