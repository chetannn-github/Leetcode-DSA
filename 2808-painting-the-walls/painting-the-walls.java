class Solution {
    int[] cost, time;
    int n;
    int INVALID = Integer.MAX_VALUE;
    HashMap<Integer, Integer>[] dp;
    
    public int paintWalls(int[] cost, int[] time) {
        this.cost = cost;
        this.time = time;
        this.n = time.length;

        dp = new HashMap[n];
        for(int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        return solve(0, 0);
    }

    private int solve(int currIdx, int free) {
        if(currIdx >= n) return free < 0 ? INVALID : 0;

        if(dp[currIdx].containsKey(free)) {
            return dp[currIdx].get(free);
        }

        long assignFree = solve(currIdx + 1, free - 1);
        long assignPaid = (0L + cost[currIdx] + solve(currIdx + 1, free + time[currIdx]));

        int ans = (int)Math.min(assignFree, assignPaid);
        dp[currIdx].put(free, ans);
        return ans;
    }
}
