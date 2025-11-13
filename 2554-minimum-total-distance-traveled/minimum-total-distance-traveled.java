class Solution {
    int R, F;
    long[][] dp;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,(a,b)->(a[0] - b[0]));

        List<Integer> expandedFactory = new ArrayList<>();

        for(int i=0; i<factory.length; i++) {
            int freq = factory[i][1], pos = factory[i][0];

            while(freq-->0) {
                expandedFactory.add(pos);
            }
        }

        R = robot.size();
        F = expandedFactory.size();
        dp = new long[R][F];
        for(long[] row : dp) Arrays.fill(row,-1);

        return solve(robot,expandedFactory, 0,0);
    }

    private long solve(List<Integer> robot, List<Integer> factory, int x, int y) {
        if(x >= R) return 0L;
        if(y >= F) return 1_000_000_000_000L;
        if(dp[x][y] != -1) return dp[x][y];

        long take = Math.abs(robot.get(x) - factory.get(y)) + solve(robot,factory,x+1,y+1);
        long skip = solve(robot,factory,x,y+1);

        return dp[x][y] = Math.min(take,skip);
    }
}