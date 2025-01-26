class Solution {
    int n1;
    int n2;
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        n1 = text1.length();
        n2 = text2.length();
        dp = new int[n1][n2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return solve(text1, text2, 0,0);
    }

    public int solve(String text1, String text2, int i, int j){
        if(i>=n1 || j>=n2){
            return 0;
        } 
        
        if(dp[i][j]!= -1){
            return dp[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] =  1 + solve(text1, text2, i+1, j+1);
        }
        int opt1 = solve(text1, text2, i+1, j);
        int opt2 = solve(text1, text2, i, j+1);
            
        return dp[i][j] = Math.max(opt1,opt2);
        


    }
}