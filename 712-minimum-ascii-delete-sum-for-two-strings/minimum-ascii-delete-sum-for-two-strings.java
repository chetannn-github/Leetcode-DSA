class Solution {
    int n1, n2;
    int[][] dp;int[] pre1, pre2;
    public int minimumDeleteSum(String s1, String s2) {
        n1 = s1.length();
        n2 = s2.length();
        pre1 = new int[n1+1];
        pre2 = new int[n2+1];

        for(int i=1; i < n1 + 1; i++) {
            pre1[i] = pre1[i-1] + s1.charAt(i-1);
        }

        for(int i=1; i < n2 + 1; i++) {
            pre2[i] = pre2[i-1] + s2.charAt(i-1);
        }

        dp = new int[n1][n2];
        for(int[] row : dp ) Arrays.fill(row, -1);

        return solve(s1, s2, 0,0);
    }

    private int solve(String s1,String s2, int i, int j) {
        if(i>=n1 && j>= n2) return 0;
        if(i>=n1) return pre2[n2] - pre2[j];
        if(j>=n2) return pre1[n1] - pre1[i];

        if(dp[i][j] != -1) return dp[i][j];


        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);
        int result = 0;
        if(ch1 == ch2) {
            result = solve(s1,s2,i+1,j+1);
        }else {
            int opt1 = ch1 + solve(s1,s2,i+1,j);
            int opt2 = ch2 + solve(s1,s2,i,j+1);

            result = Math.min(opt1,opt2);
        }
        return dp[i][j] = result;
    }
}