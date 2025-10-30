class Solution {
    String key, ring;
    int n;
    int[][] dp;
    public int findRotateSteps(String ring, String key) {
        this.key = key;
        this.ring = ring;
        this.n = ring.length();
        dp = new int[n][key.length()];

        for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        return key.length() + solve(0,0);
    }

    private int solve(int currIdx, int keyIdx) {
        if(keyIdx >= key.length()) return 0;
        if(dp[currIdx][keyIdx] != -1) return dp[currIdx][keyIdx];
        
        int myResult = Integer.MAX_VALUE;
        char currKey = key.charAt(keyIdx);
        int prev = currIdx, next = currIdx;
        
        for(int i=0; i<n; i++) {
            if(ring.charAt(prev) == currKey) {
                int currResult = i + solve(prev,keyIdx+1);
                myResult = Math.min(currResult,myResult);
            }
            prev = (prev - 1 + n) % n;
        }

        for(int i=0; i<n; i++) {
            if(ring.charAt(next) == currKey) {
                int currResult = i  + solve(next,keyIdx+1);   
                myResult = Math.min(currResult,myResult);
            }
            next = (next + 1) % n;
        }
        
        return dp[currIdx][keyIdx] = myResult;
    }
}
