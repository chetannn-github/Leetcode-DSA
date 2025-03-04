class Solution {
    int n1, n2;
    int dp[][];
    public int minDistance(String word1, String word2) {
        n1 = word1.length();
        n2 = word2.length();
        dp = new int[n1][n2];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return solve(word1,word2,0,0);
    }


    public int solve(String word1, String word2, int i, int j){
        if(i>=n1){
            return Math.abs(n2-j);
        }else if(j>=n2){
            return Math.abs(n1-i);
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int nothing = Integer.MAX_VALUE;
        if(word1.charAt(i) == word2.charAt(j)){
            nothing = solve(word1,word2, i+1, j+1);
        }
        int replace = 1 + solve(word1,word2, i+1, j+1);
        int delete = 1 + solve(word1,word2, i+1, j);
        int insert = 1 + solve(word1,word2, i, j+1);

        return dp[i][j] = Math.min(Math.min(replace,nothing),Math.min(delete,insert));
    }
}