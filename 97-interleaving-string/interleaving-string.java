class Solution {
    int l1, l2, l3;
    int dp[][][];
    public boolean isInterleave(String s1, String s2, String s3) {
        l1 = s1.length();
        l2 = s2.length();
        l3 = s3.length();
        dp = new int[l1+1][l2+1][l3];
        
        for(int[][] grid: dp){
            for(int[] row : grid ){
                Arrays.fill(row,-1);
            }
        }
        if(l1+l2!= l3) return false;

        return solve(s1,s2,s3,0,0,0);
    }

    public boolean solve(String s1, String s2, String s3, int i, int j, int k){
        if(k>=l3) return true;
        if(dp[i][j][k] != -1){
            return dp[i][j][k] == 0;
        }
        boolean ans = false;
        
        if(i>=l1){
            if(s2.charAt(j) == s3.charAt(k)){
                ans = ans || solve(s1,s2,s3,i,j+1,k+1);
            }
        }else if(j>=l2){
            if(s1.charAt(i) == s3.charAt(k)){
                ans = ans || solve(s1,s2,s3,i+1,j,k+1);
            }
        }else{
            if(s1.charAt(i) == s3.charAt(k)){
                ans = ans || solve(s1,s2,s3,i+1,j,k+1);
            }
            if(s2.charAt(j) == s3.charAt(k)){
                ans = ans || solve(s1,s2,s3,i,j+1,k+1); 
                // ek cheez batau agrr ans upr se true aagya toh fn call nhii hogiii 
            }
        }
        dp[i][j][k] = ans ? 0 : 1;

        return ans;
    }
}