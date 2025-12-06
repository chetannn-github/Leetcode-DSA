class Solution {
    int maxDigits;
    String s;
    int k,n;
    String strK;
    int MOD = 1_000_000_007;
    Integer[] dp;
    public int numberOfArrays(String s, int k) {
        this.maxDigits = (int) Math.log10(k) + 1;
        this.s = s;
        this.k = k;
        this.n = s.length();
        this.strK = k + "";
        this.dp = new Integer[n];
        return solve(0);
    }

    private int solve(int currIdx) {
        if(currIdx >= n) return 1;
        if(s.charAt(currIdx) == '0') return 0;
        if(dp[currIdx] != null) return dp[currIdx];
        
        long result = 0;
        for(int i=1; i<= Math.min(n-currIdx,maxDigits); i++) {
            if(i==maxDigits) {
                boolean canTake = checkIsSmaller(currIdx);
                if(canTake) {
                    result = (result + solve(currIdx + i) % MOD);
                }
            }else {
                result = (result + solve(currIdx+i) % MOD);
            }
        }
        
        return dp[currIdx] = (int) (result% MOD);
    }

    private boolean checkIsSmaller(int startIdx) {
        boolean result = true;
        for(int i=0; i<maxDigits; i++) {
            if(s.charAt(i+startIdx) == strK.charAt(i)) continue;
            if(s.charAt(i+startIdx) < strK.charAt(i)) return true;
            if(s.charAt(i+startIdx) > strK.charAt(i)) return false;
        }
        return result;
    }
}