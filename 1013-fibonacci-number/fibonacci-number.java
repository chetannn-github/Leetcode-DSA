class Solution {
    int dp[];
    public int fib(int n) {
        dp = new int[n+1];
        return solve(n);
    }

    public int solve(int n){
        if(n==0 || n==1){
            return dp[n] =  n;
        }

        if(dp[n]!=0){
            return dp[n];
        }

        return dp[n] = fib(n-1) + fib(n-2);
    }
}