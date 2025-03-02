class Solution {
    int n1;
    int n2;
    int dp[][];
    public int minDistance(String s1, String s2) {
        n1 = s1.length();
        n2 = s2.length();

        return  n1 + n2 - 2 *(MaxCommonSubsequence(s1,s2));


    }
    
    public int MaxCommonSubsequence(String text1, String text2) {
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
        char ch1 = text1.charAt(i);
        char ch2 = text2.charAt(j);

        if(ch1 == ch2){
            return dp[i][j] = 1  + solve(text1, text2, i+1, j+1);
        }
        int opt1 = solve(text1, text2, i+1, j);
        int opt2 = solve(text1, text2, i, j+1);
            
        return dp[i][j] = Math.max(opt1,opt2);
        
    }
}