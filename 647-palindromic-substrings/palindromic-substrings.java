class Solution {
    int n;
    int[][] dp;
    public int countSubstrings(String s) {
        n = s.length();
        dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            ans += solve(s,i,i);
        }
        return ans;
    }

    public int solve(String s, int start, int end){
        int count;
        if(end>=n){
            return 0;
        }
        
        count = isPalindrome(s,start,end);
        
        int take = solve(s,start,end+1);
        
        count += take;
        return count;
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