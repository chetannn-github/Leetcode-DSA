class Solution {
    int n;
    int dp[][];
    public boolean stoneGame(int[] piles) {
        n = piles.length;
        dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        return solve(piles,0,0) > 0;

    }

    public int solve(int[] piles , int start, int end){
        if(start>end){
            return 0;
        }
        if(dp[start][end] != Integer.MAX_VALUE){
            return dp[start][end];
        }

        int opt1 = piles[start] - solve(piles,start+1, end);
        int opt2 = piles[end] - solve(piles, start, end-1);

        return dp[start][end] = Math.max(opt1, opt2);
    }
}