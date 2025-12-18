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

        boolean isMatched = false;
        if(x < stringLength && y < patternLength) {
            isMatched = s.charAt(x) == p.charAt(y) || p.charAt(y) == '.';
        }
        

        if(y+1 < patternLength && p.charAt(y+1) == '*') {
            int skip = solve(x,y+2);
            int take = isMatched ? solve(x+1,y) : 0;
            return dp[x][y] = skip | take;
        }
        
        return dp[x][y] = isMatched ? solve(x+1,y+1) : 0;
    }
    
}