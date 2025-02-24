class Solution {
    int[][] dp;
    int mod = 1_000_000_007;
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n+1][target+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(n,k,target);
    }


    public int solve(int n, int k , int target){
        if(target == 0 && n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        if(dp[n][target]!= -1){
            return dp[n][target];
        }
        long ans = 0;
        for(int i= 1; i<=k; i++){
            if(target>= i){
                ans += solve(n-1,k,target-i);
                ans %= mod;
            }else{
                break;
            }
            
        }

        return dp[n][target] =(int)ans%mod;
    }
}