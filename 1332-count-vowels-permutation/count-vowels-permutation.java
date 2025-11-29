class Solution {
    int MOD = 1_000_000_007;
    int n;
    Integer[][] dp;
    public int countVowelPermutation(int n) {
        this.n = n;
        this.dp = new Integer[n][5];
        int result = 0;
        for(int i=0; i<5; i++) result = (result +  solve(i,1)) % MOD;
        return result;
    }

    private int solve(int prev, int length) {
        if(length == n) return 1;
        if(dp[length][prev] != null) return dp[length][prev];

        int result = 0;

        if(prev == 0) {
            result = solve(1,length+1);
            result = (result + solve(2,length+1)) % MOD;
            result = (result + solve(4,length+1)) % MOD;

        }else if(prev == 1) { 
            result = solve(0,length+1);
            result = (result + solve(2,length+1)) % MOD;
        }else if(prev == 2) {
            result = solve(1,length+1);
            result = (result + solve(3,length+1)) % MOD;
            
        }else if(prev == 3) {
            result = solve(2,length+1);
        }else if(prev == 4) {
            result = solve(2,length+1);
            result = (result + solve(3,length+1)) % MOD;
        }

        return dp[length][prev] = result;
    }
}