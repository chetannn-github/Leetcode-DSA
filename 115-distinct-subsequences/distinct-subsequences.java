class Solution {
    int m,n;
    String s,t;
    Integer[][] dp;
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        this.m = s.length();
        this.n = t.length();
        this.dp = new Integer[m][n];

        return solve(0,0);
    }

    private int solve(int x, int y) {
        if(x>=m || y>=n) {
            return y>=n ? 1 : 0;
        }
        if(dp[x][y] != null) return dp[x][y];

        int result = 0;

        if(s.charAt(x) == t.charAt(y)) {
            result += solve(x+1,y+1);
        }

        result += solve(x+1,y);

        return dp[x][y] = result;

        
    }
}