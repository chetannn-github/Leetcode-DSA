class Solution {
    int[] dp;
    public int integerBreak(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp,-1);
        return solve(n,true);
    }


    public int solve(int n, boolean first){
        if(n == 1) return 1;
        if(dp[n] != -1) return dp[n];
        

        int result = 1;
        int lastNum = first ? n-1 : n;
        for(int i=1; i<= lastNum ; i++) {
            int currRes = i * solve(n-i, false);
            result = Math.max(currRes,result);
        }

        return dp[n] = result;
    }
}