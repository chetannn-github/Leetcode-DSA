class Solution {
    int n;
    HashMap<Integer,Integer> dp;
    public int coinChange(int[] coins, int amount) {
        dp = new HashMap<>();
        Arrays.sort(coins);
        this.n = coins.length;
        int result = solve(coins,amount);
        return result == Integer.MAX_VALUE ? - 1 : result;
    }

    public int solve(int[] coins, int currAmt) {
        if(currAmt == 0) return 0;
        if(dp.containsKey(currAmt)) return dp.get(currAmt);

        int result = Integer.MAX_VALUE;
        for(int i=0; i<n && coins[i] <= currAmt; i++) {
            int leftAmtResult = solve(coins,currAmt - coins[i]);
            if(leftAmtResult != Integer.MAX_VALUE) {
                int currResult  = 1 + leftAmtResult;
                result = Math.min(result, currResult);
            }

        }
        dp.put(currAmt,result);
        return result;
    }
}