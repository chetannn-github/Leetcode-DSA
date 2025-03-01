class Solution {
    int n;
    int[] dp;
    HashSet<String> hs;

    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        dp = new int[n];
        hs = new HashSet<>();

        for(String word : wordDict){
            hs.add(word);
        }
        Arrays.fill(dp,-1);
       
        return solve(s,0) > 0 ? true : false;
    }

    public int solve(String s,int start){
        if(start>=n){
            return 1;
        }
        if(dp[start]!=-1){
            return dp[start];
        }
        int ans = 0;
        for(int i=start; i<n; i++){
            if(hs.contains(s.substring(start, i+1))){
                int next = solve(s,i+1);
                ans |= next;
                if(ans == 1) return dp[start] = 1;
            }
        }
        return dp[start] = ans;
    }

}    
  