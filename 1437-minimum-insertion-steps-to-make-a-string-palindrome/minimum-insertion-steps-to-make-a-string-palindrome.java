class Solution {
    String s;
    int n;
    Integer[][] dp;
    public int minInsertions(String s) {
        this.s = s;
        this.n = s.length();
        this.dp = new Integer[n][n];
        return solve(0,n-1);
    }

    private int solve(int left, int right) {
        if(left >= right) return 0;
        if(dp[left][right] != null) return dp[left][right];

        char leftChar = s.charAt(left);
        char rightChar = s.charAt(right);

        int result = 0;
        if(leftChar == rightChar) {
            result = solve(left+1,right-1);
        }else {
            result = 1 + Math.min(solve(left+1,right), solve(left,right-1));
        }

        return dp[left][right] = result;
    }
}