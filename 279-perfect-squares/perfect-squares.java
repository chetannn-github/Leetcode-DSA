class Solution {
    
    int[] dp = new int[10001];
    public int numSquares(int n) {
        Arrays.fill(dp,-1);
        int result = solve(n,n);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int solve(int n , int target){
        
        if(target==0){
            return 0;
        }
        if(target<0 ){
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        if(dp[target]!= -1){
            return dp[target];
        }

        for(int i=(int)Math.sqrt(n); i>0; i--){
            int result = solve(n,target-i*i);

            if(result != Integer.MAX_VALUE){
                min = Math.min(result+1,min);
            }
            
        }
        dp[target] = min;
        return min;
    }
}