class Solution {
    int MOD = 1_000_000_007;
    int[] nums;
    int target1, target2,n;
    HashMap<String,Integer>[] dp;
    
    public int alternatingXOR(int[] nums, int target1, int target2) {
        this.n = nums.length;
        this.nums = nums;
        this.target1 = target1;
        this.target2 = target2;
        this.dp = new HashMap[n];

        for(int i=0; i<n; i++) dp[i] = new HashMap<>();

        return solve(0,0,target1);
    }

    private int solve(int currIdx, int currXOR, int target) {
        currXOR ^= nums[currIdx];
        if(currIdx == n-1) {
            return target == currXOR ? 1 : 0;
        }

        String key = currXOR + " " + target;

        if(dp[currIdx].containsKey(key)) return dp[currIdx].get(key);
        
        long parition = 0L;
        if(currXOR == target) {
            int nextTarget = target == target1 ? target2 : target1;
            parition = solve(currIdx+1, 0, nextTarget);
        }

        long carryOn = solve(currIdx+1, currXOR,target);

        int result = (int) ((parition + carryOn) % MOD);
        dp[currIdx].put(key,result);
        return result;
    }
}