class Solution {
    int n;
    int dp[][];
    public int maxProfit(int[] prices, int fee) {
        n = prices.length;
        dp = new int[n][2];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(prices,0, 0,fee);
    }


    public int solve(int[] prices, int bought, int curr,int fee){
        if(curr>=n){
            return 0;
        }

        if(dp[curr][bought] != -1){
            return dp[curr][bought];
        }
        // option 1 : buy (agr phele se nhi kiya hain toh)
        // option 2 : sell (if bought earlier)
        int maxProfit = Integer.MIN_VALUE;

        if(bought == 1){
            maxProfit = Math.max(maxProfit,prices[curr]- fee + solve(prices,0,curr+1,fee));
        }else{
            maxProfit = Math.max(-prices[curr]+solve(prices,1,curr+1,fee),maxProfit);
        }
         // option 3 : skip( chill mode )
        maxProfit = Math.max(solve(prices, bought,curr+1,fee),maxProfit);
       
        
        dp[curr][bought] =  maxProfit;
        
        return maxProfit;
    }
}
  