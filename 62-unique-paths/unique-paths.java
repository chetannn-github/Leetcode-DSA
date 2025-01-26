class Solution {
    int[][] dp ;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        return solve(m,n,0,0); 
    }

    public int solve(int m, int n, int i, int j){
        if(i>=m  || j>=n){
            return 0;
        } 
        if(i == m-1 && j == n-1){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        // right --> j+1
        int opt1 = solve(m,n,i,j+1);
        
        // down --> i+1
        int opt2 = solve(m,n,i+1,j);

        return dp[i][j] = opt1 + opt2;
    }
}