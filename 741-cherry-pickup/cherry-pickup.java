class Solution {
    int n;
    int[][] grid;
    Integer[][][] dp;
    
    public int cherryPickup(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        this.dp = new Integer[n][n][n];
        
        return Math.max(0, solve(0, 0, 0));
    }

    private int solve(int r1, int c1, int c2) {
        int r2 = r1 + c1 - c2;
        
        if(r1 >= n || c1 >= n || r2 >= n || c2 >= n || 
           grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        
        if(r1 == n-1 && c1 == n-1) {
            return grid[r1][c1];
        }
        
        if(dp[r1][c1][c2] != null) {
            return dp[r1][c1][c2];
        }
        
        int cherries = grid[r1][c1];
        if(r1 != r2 || c1 != c2) {
            cherries += grid[r2][c2];
        }
        
        int remaining = Integer.MIN_VALUE;
        remaining = Math.max(remaining, solve(r1+1, c1, c2));   
        remaining = Math.max(remaining, solve(r1+1, c1, c2+1)); 
        remaining = Math.max(remaining, solve(r1, c1+1, c2));  
        remaining = Math.max(remaining, solve(r1, c1+1, c2+1));
        
        return dp[r1][c1][c2] = cherries + remaining;
    }
}