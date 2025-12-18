class Solution {
    String s,p;
    int stringLength, patternLength;
    Integer[][] dp;
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        this.stringLength = s.length();
        this.patternLength = p.length();
        this.dp = new Integer[21][21];
        return solve(0,0) == 1;
    }

    private int solve(int x, int y) {
        if( y >= patternLength) {
            return (x >= stringLength) ? 1 : 0;
        }
        if(dp[x][y] != null) return dp[x][y];

        boolean currMatching = false;
        if(x < stringLength && y < patternLength) {
            char stringChar = s.charAt(x);
            char patternChar = p.charAt(y);
            if(stringChar == patternChar || patternChar == '.') {
                currMatching = true;
            }
        }
        int result = 0;

        if(y+1 < patternLength && p.charAt(y+1) == '*') {
            result = solve(x,y+2);
            if(result == 1) return dp[x][y] = 1;
            if(currMatching) {
                result = solve(x+1,y);
            }
            return dp[x][y] = result;
        }

        

        if(currMatching) {
            return dp[x][y] = solve(x+1,y+1);
        }
        return dp[x][y] = 0;

    }
    
}