class Solution {
    int n,k; int[] houses;
    Long[][] dp;
    Integer INVALID = Integer.MAX_VALUE;
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        this.n = houses.length;
        this.houses = houses;
        this.dp = new Long[n][k+1];
        this.k = k;
        return (int) solve(0,0);
    }

    
    private long solve(int currIdx, int groupMade) {
        if(groupMade > k) return INVALID;
        if(currIdx == n) {
            return groupMade == k ? 0 : INVALID;
        }
        if(dp[currIdx][groupMade] != null) return dp[currIdx][groupMade];
        
        long result = INVALID;
        for(int i= currIdx; i<n; i++) {
            int median = houses[(i + currIdx)/2];
            int cost = 0;

            for(int j=currIdx; j<=i; j++) {
                cost += Math.abs(median - houses[j]);
            }

           result = Math.min(result,cost + solve(i+1,groupMade+1));
        }
        return dp[currIdx][groupMade] = result;


    }
}