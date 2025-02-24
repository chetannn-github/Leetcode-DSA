class Solution {
    int n;
    double dp[][];
    public double largestSumOfAverages(int[] nums, int k) {
        n = nums.length;
        dp = new double[n+1][k+1];
        
        return solve(nums,k,0);
    }


    public double solve(int[] nums, int k, int start){
        if(start>=n){
            return 0;
        }

        if(dp[start][k]!=0){
            return dp[start][k];
        }
        int sum = 0;
        double ans = 0;

        for(int i= start ; i<n; i++){
            sum += nums[i];
            
            if(k>1){
                double possibleAns = ((double)sum/(i-start+1)) + solve(nums,k-1,i+1);
                ans = Math.max(possibleAns,ans);
            }
        }
        
        double anotherPossibleAns = ((double)sum / (n- start));
        ans = Math.max(anotherPossibleAns,ans);
        return dp[start][k] = ans;
    }
}