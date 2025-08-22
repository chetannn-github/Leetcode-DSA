class Solution {
    int n;
    HashMap<Integer, Boolean> dp;
    public boolean canJump(int[] nums) {
        n = nums.length;
        dp = new HashMap<>();
        return solve(nums, 0);
    }


    public boolean solve(int[] nums, int idx) {
        if(idx >= n-1) return true;
        if(dp.containsKey(idx)) return dp.get(idx);
        boolean ans = false;
        for(int jump=1; jump<=nums[idx]; jump++) {
            ans |= solve(nums, idx + jump);

            if(ans) return ans;
        } 
        dp.put(idx,ans);
        return ans;
    } 
} 