class Solution {
    int n;
    int[][] dp;
    int maxLength = 0;
    int resultStart = 0, resultEnd = 0;

    public String longestPalindrome(String s) {
        n = s.length(); 
        dp = new int[n+1][n+1];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            solve(s,i,i);
        }
        return s.substring(resultStart, resultEnd);
    }

    public void solve(String s, int start, int end){
        if(end>=n){
            return;
        }
        
        if(isPalindrome(s,start,end) == 1) {
            if(maxLength < end - start + 1) {
                maxLength = end - start + 1;
                resultStart = start;
                resultEnd = end + 1;
            }
        }
        
        solve(s,start,end+1);
        return ;
    }

    public int isPalindrome(String s, int left, int right) {
        if(left>=right){
            return 1;
        }
        if(dp[left][right]!=-1){
            return dp[left][right];
        }
        if (s.charAt(left) != s.charAt(right)) {
            return dp[left][right] = 0;
        }
        
        return dp[left][right] = isPalindrome(s,left+1,right-1);
    }
}