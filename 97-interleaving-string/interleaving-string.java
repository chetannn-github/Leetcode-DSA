class Solution {
    int n1, n2, n3;
    int[][][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        n1 = s1.length();
        n2 = s2.length();
        n3 = s3.length();
        if(n1 + n2 != n3) return false;
        
        dp = new int[n1+1][n2+1][n3+1];

        for(int[][] grid: dp){
            for(int[] row : grid ){
                Arrays.fill(row,-1);
            }
        }
        
        return solve(s1,s2,s3,0,0,0);
    }


    public boolean solve(String s1, String s2, String s3, int i,int j, int k) {
        if(k >= n3) return true;

        if(dp[i][j][k] != -1) return dp[i][j][k] == 0;

        boolean result = false;
        char ch3 = s3.charAt(k);

        if(i < n1 && s1.charAt(i) == ch3) {
            result |= solve(s1,s2,s3,i+1,j,k+1);
        }

        if(!result && j<n2 && s2.charAt(j) == ch3) {
            result |= solve(s1,s2,s3,i,j+1,k+1);
        }

        dp[i][j][k] = result ? 0 : 1;
    
        return result;
    }
}