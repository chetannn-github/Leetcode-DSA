class Solution {
    int dp[];
    int mod = 1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int[high+1];
        Arrays.fill(dp,-1);
        return  solve(low,high,zero,one,0);
    }


    public int solve(int low, int high, int zero, int one, int currentLength){
        
        int ans = 0;
        if(dp[currentLength] != -1){
            return dp[currentLength];
        }
        if(currentLength + zero >= low && currentLength + zero <= high){
            ans += 1 + solve(low,high,zero,one, currentLength+ zero);
        }else if(currentLength + zero < low){
            ans += solve(low,high,zero,one, currentLength+ zero);
        }
        
        if(currentLength+ one >= low && currentLength + one <= high){
            ans += 1 + solve(low,high,zero,one, currentLength+ one);
        }else if(currentLength + one < low){
            ans += solve(low,high,zero,one, currentLength+ one);
        }

        return dp[currentLength] = ans % mod;
    }
}