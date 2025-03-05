class Solution {
    int n;
    int[][] dp;
    public int countSubstrings(String s) {
        n = s.length();
        
        dp = new int[n+1][n+1];
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
            return dp[start][end] = 0;
        }
        // if(dp[start][end]!=-1){
        //     return dp[start][end];
        // }
        count = isPalindrome(s,start,end);
        
        int take = solve(s,start,end+1);
        
        count += take;
        return dp[start][end] = count;
    }

    public int isPalindrome(String s, int left, int right) {
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return 0;
            }
            left++;
            right--;
        }
        return 1;
    }
}