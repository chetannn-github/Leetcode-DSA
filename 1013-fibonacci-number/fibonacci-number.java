// class Solution {
    
//     public int fib(int n) {
//         int dp[];
//         dp = new int[n+1];
//         return solve(n,dp);
//     }

//     public int solve(int n,int[] dp){
//         if(n==0 || n==1){
//             return dp[n] =  n;
//         }

//         if(dp[n]!=0){
//             return dp[n];
//         }

//         return dp[n] = fib(n-1) + fib(n-2);
//     }
// }


class Solution {
    public int fibo(int n,int[] dp){
        if(n<2) return n;
        dp[0]=0;
        dp[1]=1;
        if(dp[n]!=0) return dp[n];
        return dp[n]= fibo(n-1,dp)+fibo(n-2,dp);
    }
    public int fib(int n) {
       // if(n<2) return n;
        int[] dp=new int[n+1];
        return fibo(n,dp);
    }
}