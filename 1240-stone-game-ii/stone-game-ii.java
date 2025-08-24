class Solution {
    int n;
    int[][][] dp;
    int NOT_VISITED_VAL = -1;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new int[n+1][n+1][2];

        for(int[][] grid : dp) {
            for(int[] arr : grid) Arrays.fill(arr, NOT_VISITED_VAL);
        }
        return solve(piles,0,1,1);
    }

    public int solve(int[] piles, int currIdx, int M, int alice) {
        if(currIdx >= n) return 0;
        if(dp[currIdx][M][alice] != NOT_VISITED_VAL) return dp[currIdx][M][alice];

        int result = alice == 1 ? 0 : Integer.MAX_VALUE;
         
        int stonesSum = 0;
        for(int i= currIdx; i< Math.min(n, currIdx + 2*M); i++) {
            stonesSum += piles[i];
            int nextM = Math.max(i - currIdx + 1, M);

            int res = (alice == 1 ? stonesSum : 0) + solve(piles, i+1, nextM, 1-alice);

            if(alice == 1) result = Math.max(result,res);
            else result = Math.min(result,res);
            
        }
        
        return dp[currIdx][M][alice] = result;
    }
}