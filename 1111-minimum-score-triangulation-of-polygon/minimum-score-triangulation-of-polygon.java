
class Solution {
    int dp[][];
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        dp = new int[n][n];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(0,n-1,values);
    }
    
    private int solve(int i,int j,int values[]){
        if (i+1 == j) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        int mini = Integer.MAX_VALUE;
    
        for (int k=i+1;k<j;k++){
            int steps = values[i] * values[k] * values[j]
                + solve(i,k,values)
                + solve(k,j,values);
            mini = Math.min(steps,mini);
        }
        
        return dp[i][j] = mini;
    }
}