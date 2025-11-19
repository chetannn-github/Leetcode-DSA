class Solution {
    int n,k;
    List<Integer>[] graph;
    int[] coins;
    int[][] dp;
    int NOT_CACHED = Integer.MIN_VALUE;

    public int maximumPoints(int[][] edges, int[] coins, int k) {
        this.n = coins.length;
        this.k = k;
        this.coins = coins;

        dp = new int[n][15];
        for(int[] row : dp) Arrays.fill(row,NOT_CACHED);

        constructGraph(edges);

        return solve(0,0,-1);
    }

    private void constructGraph(int[][] edges) {
        graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
    }

    private int solve(int curr, int reduceMultiple, int parent) {
        if(reduceMultiple > 14) return 0;
        if(dp[curr][reduceMultiple] != NOT_CACHED) return dp[curr][reduceMultiple];

        int currVal = coins[curr] >> reduceMultiple;

        int result = 0;

        int opt1 = (currVal - k) ;
        int opt2 = (currVal >> 1) ;

        for(int nbr : graph[curr]) {
            if(nbr == parent) continue;
            opt1 += solve(nbr, reduceMultiple, curr);
            opt2 += solve(nbr, reduceMultiple+1, curr);
            
        }

        return dp[curr][reduceMultiple] = Math.max(opt1, opt2);
    }
}
