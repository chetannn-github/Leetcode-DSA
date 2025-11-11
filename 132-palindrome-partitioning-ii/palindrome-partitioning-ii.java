class Solution {
    int[][] palindromeDP;
    int[][] dp;
    int n;
    public int minCut(String s) {
        n = s.length();
        palindromeDP = new int[n][n];
        dp = new int[n+1][n+1];
        
        for(int i=0; i<n; i++) {
            if(i<n) Arrays.fill(palindromeDP[i],-1);
            Arrays.fill(dp[i],-1);
        }
        return solve(s,0,0);
    }

    private int solve(String s, int start,int curr) {
        if(dp[start][curr] != -1) return dp[start][curr];
        if(curr >= n) return dp[start][curr] = isPalindrome(s, start, curr-1) ? 0 : Integer.MAX_VALUE;


        int skip = solve(s, start, curr+1);
        int take = Integer.MAX_VALUE;
        if(isPalindrome(s,start, curr)) {
            take = 1 + solve(s,curr+1, curr+1);
        }
        return dp[start][curr] = Math.min(skip,take);
    }

    private boolean isPalindrome(String s, int start,int end) {
        if(start >= end) return true;
        if(palindromeDP[start][end] != -1 ) return palindromeDP[start][end] == 1;

        boolean result = s.charAt(start) == s.charAt(end) && isPalindrome(s,start+1, end-1);
        palindromeDP[start][end] =  result ? 1 : 0;
        return result;
    }
}