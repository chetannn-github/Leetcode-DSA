class Solution {
      int[][] dp ;
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length; 
        dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        return solve(grid, m,n,0,0); 
    }

    public int solve(int[][] grid,int m, int n, int i, int j){
        if(i>=m  || j>=n || grid[i][j]==1){
            return 0;
        } 
        if(i == m-1 && j == n-1){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        // right --> j+1
        int opt1 = solve(grid,m,n,i,j+1);
        
        // down --> i+1
        int opt2 = solve(grid,m,n,i+1,j);

        return dp[i][j] = opt1 + opt2;
    }
}