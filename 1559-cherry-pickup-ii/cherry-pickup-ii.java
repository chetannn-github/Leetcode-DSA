class Solution {
    int rows,cols;
    int[][] grid;
    Integer[][][] dp;
    
    public int cherryPickup(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = grid;
        this.dp = new Integer[rows][cols][cols];

        return Math.max(0, solve(0, 0, cols-1));
    }

    private int solve(int r, int c1, int c2) {
        int cherry = c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2];
        if(r == rows-1) return cherry;
        
        if(dp[r][c1][c2] != null) return dp[r][c1][c2];
    
        int[] dirns = {-1,0,1};
        
        int maxCherry = cherry;
        for(int one : dirns) {
            int nc1 = c1 + one;
            if(nc1 >=cols || nc1 < 0 ) continue;
            for(int two : dirns) {
                int nc2 = c2 + two;
                if(nc2 >=cols || nc2 <0) continue;

                maxCherry = Math.max(maxCherry,cherry + solve(r+1,nc1,nc2));
            }
        }
        
        
        
        return dp[r][c1][c2] = maxCherry;
    }
}