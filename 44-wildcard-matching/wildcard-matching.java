class Solution {
    String s,modP;
    int stringLength, patternLength;
    Integer[][] dp;
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.modP = fixConsecutiveStars(p);
        this.stringLength = s.length();
        this.patternLength = modP.length();
        
        this.dp = new Integer[stringLength][patternLength];

        return solve(0,0) == 1;
        
    }

    private int solve(int x, int y) {
        if(x == stringLength || y == patternLength) {
            if(x == stringLength && y != patternLength) return checkLastStars(modP,y);
            return (x == stringLength && y == patternLength) ? 1 : 0;
        }

        if(dp[x][y] != null) return dp[x][y];

        char stringChar = s.charAt(x);
        char patternChar = modP.charAt(y);

        if(stringChar == patternChar || patternChar == '?') {
            return solve(x+1, y+1);
        }
        if(patternChar != '*') return 0;

        int result = 0;

        for(int nextIdx = x; nextIdx <= stringLength; nextIdx++) {
            result = solve(nextIdx, y+1);
            if(result == 1) break;
        }
        return dp[x][y] = result;

    }

    private int checkLastStars(String pattern, int start) {
        for(int i=start; i<patternLength; i++) {
            char ch = pattern.charAt(i);
            if(ch != '*') return 0;
        }

        return 1;
    }

    private String fixConsecutiveStars(String s) {
        StringBuilder sb = new StringBuilder();
        int currSize = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '*' && currSize > 0 && sb.charAt(currSize-1) == '*') continue;
            sb.append(ch);
            currSize++;
        }

        return sb.toString();
    }
}