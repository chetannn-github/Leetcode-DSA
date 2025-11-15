class Solution {
    int MOD = 1_000_000_007;
    int start,finish,n;
    int[][] dp;
    int NOT_CACHED = -1;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        this.start = start;
        this.finish = finish;
        this.n = locations.length;

        dp = new int[n][fuel+1];
        for(int[] row : dp)  Arrays.fill(row,NOT_CACHED);

        return solve(locations,start,fuel);
    }


    private int solve(int[] locations,int currCity, int fuelLeft) {
        if(fuelLeft < 0) return 0;  
        if(dp[currCity][fuelLeft] != NOT_CACHED) return dp[currCity][fuelLeft];    

        int result = currCity == finish ? 1 : 0;
        for(int i=0; i<n; i++) {
            if(i == currCity) continue;

            result += solve(locations,i,fuelLeft - Math.abs(locations[i] - locations[currCity]));
            result %= MOD;
        }

        return dp[currCity][fuelLeft] = result;
    }
}