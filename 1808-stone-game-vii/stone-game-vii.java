class Solution {
    int n;
    int dp[][];
    int pre[];
    public int stoneGameVII(int[] piles) {
        n = piles.length;
        dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        pre = new int[n+1];
        for(int i=1; i<n+1; i++){
            pre[i] = pre[i-1] + piles[i-1];
        }
        return solve(piles,0,n-1);

    }

    public int solve(int[] piles , int start, int end){
        if(start>end){
            return 0;
        }
        if(dp[start][end] != Integer.MAX_VALUE){
            return dp[start][end];
        }
        

        int opt1 = pre[end+1] - pre[start] - piles[start] - solve(piles,start+1, end);
        int opt2 = pre[end+1] - pre[start] - piles[end] - solve(piles, start, end-1);

        return dp[start][end] = Math.max(opt1, opt2);
    }
}