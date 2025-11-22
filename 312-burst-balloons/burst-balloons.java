class Solution {
    List<Integer> numsMod;
    Integer[][] dp;
    int k;
    public int maxCoins(int[] nums) {
        this.k = nums.length + 2;
        this.dp = new Integer[k][k];
        this.numsMod = new ArrayList<>();

        numsMod.add(1);
        for(int num : nums) numsMod.add(num);
        numsMod.add(1);
        return solve(0,k-1);
    }

    private int solve(int startIdx, int endIdx) {
        if(endIdx - startIdx == 1) return 0;
        if(dp[startIdx][endIdx] != null) return dp[startIdx][endIdx];

        int result = 0;
        for(int i=startIdx+1; i<endIdx; i++) {
            int start = numsMod.get(startIdx), end = numsMod.get(endIdx);
            int currResult = (start * end * numsMod.get(i)) + solve(startIdx, i) + solve(i, endIdx);
            result = Math.max(currResult,result);
        }
        
        return dp[startIdx][endIdx] = result;
    }
}