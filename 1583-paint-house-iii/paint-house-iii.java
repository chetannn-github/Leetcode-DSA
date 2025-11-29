class Solution {
    int[] houses; int[][] cost; int m, n,target;
    int INVALID = Integer.MAX_VALUE;
    Integer[][][] dp;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.cost = cost;
        this.m = m;
        this.n = n;
        this.target = target;
        this.dp = new Integer[n+1][m+1][target+1];
        
        int result = solve(-1,0,0);
        
        return result == INVALID ? -1 : result;
    }

    private int solve(int prevColor, int currIdx, int nbrs) {
        if(currIdx == m) return nbrs == target ? 0 : INVALID;
        if(nbrs > target) return INVALID;
        if(dp[prevColor+1][currIdx][nbrs] != null) return dp[prevColor+1][currIdx][nbrs];

        if(houses[currIdx] != 0) return solve(houses[currIdx] -1, currIdx+1,nbrs + (houses[currIdx]-1 == prevColor ? 0 : 1));

        int result = INVALID;

        if((prevColor == -1 || nbrs < target)) {
            for(int color=0; color<n; color++) {
                if(color == prevColor) continue;
                int remainingResult = solve(color,currIdx+1,nbrs+1);
                if(remainingResult != INVALID) {
                    result = Math.min(result, cost[currIdx][color] + remainingResult);
                }
            }
        }

        if(prevColor != -1) {
            int remainingResult = solve(prevColor,currIdx+1,nbrs);
            if(remainingResult != INVALID) {
                result = Math.min(result, cost[currIdx][prevColor] + remainingResult);
            }
        }

        return dp[prevColor+1][currIdx][nbrs] = result;

    }
}