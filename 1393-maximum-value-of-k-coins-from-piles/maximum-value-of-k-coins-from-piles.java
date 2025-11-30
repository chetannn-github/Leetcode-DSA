class Solution {
    int n,k;
    List<List<Integer>> piles;
    Integer INVALID = Integer.MIN_VALUE;
    Integer[][] dp;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        this.n = piles.size();
        this.piles = piles;
        this.k = k;
        this.dp = new Integer[n][k];

        return solve(0,0);
    }

    private int solve(int currIdx, int coinsTaken) {
        if(coinsTaken > k) return INVALID;
        if(currIdx >= n) return coinsTaken == k ? 0 : INVALID;
        if(coinsTaken == k) return 0;
        if(dp[currIdx][coinsTaken] != null) return dp[currIdx][coinsTaken];

        int cumSum = 0;
        int maxVal = 0;
        for(int i=0; i<piles.get(currIdx).size(); i++) {
            cumSum += piles.get(currIdx).get(i);
            maxVal = Math.max(maxVal,cumSum + solve(currIdx+1,coinsTaken+i+1));
        }   
        maxVal = Math.max(maxVal,solve(currIdx+1,coinsTaken));

        return dp[currIdx][coinsTaken] = maxVal;
    }
}