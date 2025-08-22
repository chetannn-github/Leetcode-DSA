class Solution {
    int n;
    int[][] dp;
    public int minFlipsMonoIncr(String s) {
        this.n = s.length();
        dp = new int[n][2];
        for(int[] row : dp) Arrays.fill(row,-1);

        boolean isZero = s.charAt(0) == '0';
        int flip = Integer.MAX_VALUE;
        int notFlip = Integer.MAX_VALUE;

        if(isZero) {
            flip = 1 + solve(s,1, 1);
            notFlip = solve(s,0,1);
        }else {
            flip = 1 + solve(s,0, 1);
            notFlip = solve(s,1,1);
        }

        return solve(s,0,0);
    }

    public int solve(String s, int prevVal, int currIdx) {
        if(currIdx >= n) return 0;

        if(dp[currIdx][prevVal] != -1) return dp[currIdx][prevVal];
    
        boolean isZero = s.charAt(currIdx) == '0';
        int flip = Integer.MAX_VALUE;
        int notFlip = Integer.MAX_VALUE;

        if(prevVal == 0) {
            if(isZero) {
                notFlip = solve(s,prevVal, currIdx + 1);
            }else {
                flip = 1 + solve(s,0, currIdx + 1);
                notFlip = solve(s,1,currIdx + 1);
            }
        }else {
            if(isZero) {
                flip = 1 + solve(s,1, currIdx + 1);
            }else {
                notFlip = solve(s,prevVal, currIdx + 1);
            }
        }

        return dp[currIdx][prevVal] = Math.min(flip, notFlip);
    }
}