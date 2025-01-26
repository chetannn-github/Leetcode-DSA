class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length; 
        dp = new int[m][n];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        return solve(grid, m,n,0,0); 
    }

    public int solve(int[][] grid,int m, int n, int i, int j){
        if(i == m-1 && j == n-1){
            return grid[m-1][n-1];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int opt1 = Integer.MAX_VALUE;
        int opt2 = Integer.MAX_VALUE;

        // ek toh hamesha hoogaa hii feasiblee kuki hum abhii tk goal prr nhi pahuche 
        // right --> j+1
        if(j+1<n){
            opt1 =  grid[i][j] + solve(grid,m,n,i,j+1);
        } 
        // down --> i+1
        if(i+1<m){
            opt2 = grid[i][j] + solve(grid,m,n,i+1,j);
        }
       
        return dp[i][j] = Math.min(opt1 , opt2);
    }
}