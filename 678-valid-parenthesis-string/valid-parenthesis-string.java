class Solution {
    int N;
    int[][] dp;
    public boolean checkValidString(String s) {
        N = s.length();
        dp = new int[N][N];

        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(s,0,0);
    }

    public boolean solve(String s, int currIdx, int open) {
        if(currIdx == N ) return open == 0;
        
        if(dp[currIdx][open] != -1) return dp[currIdx][open] == 1;

        boolean isOpen = s.charAt(currIdx) == '(';
        boolean isClose = s.charAt(currIdx) == ')';
        boolean result = false;

        if(isOpen) result = solve(s,currIdx+1, open+1);
        else if (isClose) result = open > 0 && solve(s,currIdx+1,open-1);
        else {
            result = solve(s,currIdx+1,open+1) || 
            (open > 0 && solve(s,currIdx+1,open-1)) || 
            solve(s,currIdx+1,open);
        }

        dp[currIdx][open] = result ? 1 : 0 ;
        return result;
    }
}