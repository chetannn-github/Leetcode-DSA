class Solution {
    int n,k;
    String s;
    Integer[][][][] dp;

    public int getLengthOfOptimalCompression(String s, int k) {
        this.s = s;
        this.k = k;
        this.n = s.length();
        this.dp = new Integer[26][n][n][k+1];
        return solve(0,0,0,k);
    }

    private int solve(int prev, int curr, int freq, int skipLeft) {
        if(skipLeft < 0) return Integer.MAX_VALUE;
        if(curr >= n) return countDigitsInCompression(freq);
        if(dp[prev][curr][freq][skipLeft] != null) return dp[prev][curr][freq][skipLeft];

        int newFreq = prev == s.charAt(curr) - 'a' ? freq + 1 : 1;
        int add = prev == s.charAt(curr) - 'a' ? 0 : countDigitsInCompression(freq);

        int take = add + solve(s.charAt(curr) -'a',  curr+1, newFreq, skipLeft);
        int skip = solve(prev, curr+1, freq, skipLeft - 1);

        return dp[prev][curr][freq][skipLeft] = Math.min(take, skip);
    }

    private int countDigitsInCompression(int num) {
        if (num <= 1) return num;
        if (num <= 9) return 2;
        if (num <= 99) return 3;
        return 4;
    }
}
