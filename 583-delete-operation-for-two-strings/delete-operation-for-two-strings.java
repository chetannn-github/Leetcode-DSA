class Solution {
    int n1, n2;
    int[][] dp;
    public int minDistance(String word1, String word2) {
        n1 = word1.length();
        n2 = word2.length();

        dp = new int[n1][n2];
        for(int[] row : dp ) Arrays.fill(row, -1);

        return solve(word1, word2, 0,0);
    }

    private int solve(String word1,String word2, int i, int j) {
        if(i>=n1 && j>= n2) return 0;
        if(i>=n1) return n2- j;
        if(j>=n2) return n1 - i;

        if(dp[i][j] != -1) return dp[i][j];


        char ch1 = word1.charAt(i);
        char ch2 = word2.charAt(j);
        int result = 0;
        if(ch1 == ch2) {
            result = solve(word1,word2,i+1,j+1);
        }else {
            int opt1 = 1 + solve(word1,word2,i+1,j);
            int opt2 = 1+ solve(word1,word2,i,j+1);

            result = Math.min(opt1,opt2);
        }
        return dp[i][j] = result;
    }
}