class Solution {
    int n;
    HashMap<Integer,Integer> map;
    int[][] dp;
    public boolean canCross(int[] stones) {
        if(stones[1] - stones[0] != 1) return false;
        n = stones.length;
        map = new HashMap<>();
        dp = new int[n][n];

        for(int i=0; i<n; i++) {
            map.put(stones[i], i);
            Arrays.fill(dp[i], -1);
        }
        return solve(stones,1,1);
    }

    public boolean solve(int[] stones, int currIdx, int k) {
        if(currIdx == n-1) return true;
        if(dp[currIdx][k] != -1) return dp[currIdx][k] == 1;

        boolean result = false;

        result = result || (k != 1 && map.containsKey(stones[currIdx] + k-1) ? solve(stones,map.get(stones[currIdx] + k-1),k-1) : false);
        result = result || (map.containsKey(stones[currIdx] + k) ? solve(stones,map.get(stones[currIdx] + k),k) : false);
        result = result || (map.containsKey(stones[currIdx] + k+1) ? solve(stones,map.get(stones[currIdx] + k+1),k+1) : false);
        dp[currIdx][k] = result ? 1 : 0;
        return result;
    }
}