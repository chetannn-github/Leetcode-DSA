class Solution {
    int n;
    int MOD = 1_000_000_007;
    int[] nums;
    Integer[][][] dp = new Integer[n][52][52];

    public int countOfPairs(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.dp = new Integer[n][52][52];
        
        return solve(0,0,51);
    }

    private int solve(int currIdx, int firstPrev, int secPrev) {
        if(currIdx >= n) return 1;
        if(dp[currIdx][firstPrev][secPrev] != null) return dp[currIdx][firstPrev][secPrev];

        int val = nums[currIdx];
        long result = 0L;
        for(int i=firstPrev; i<=val; i++) {
            if(val-i > secPrev) continue; 
            result = (result + solve(currIdx+1,i,val-i)) % MOD;
        }

        return dp[currIdx][firstPrev][secPrev] = (int) result;
    }
}