class Solution {
    Set<String> hs = new HashSet<>();
    int n ;
    int dp[];

    public int numDecodings(String s) {
        for (int i = 1; i <= 26; i++) {
            String key = String.valueOf(i);
            hs.add(key);
        }
        n = s.length();
        dp = new int[n];
        Arrays.fill(dp,-1);

        return solve(s,0);
        
    }

    public int solve(String s, int start){
        
        if(start == n){
            return 1;
        }

        if(dp[start] != -1){
            return dp[start];
        }

        String one = s.substring(start, start+1);
        int r1 = 0;
        int r2 = 0;
        if(hs.contains(one)){
           r1 = solve(s,start+1);
        }

        dp[start] = r1;
        if(start+1 == n){
            return r1;
        }

        String two = s.substring(start, start+2);
        if(hs.contains(two)){
            r2 = solve(s,start+2);
        }
        dp[start] = r1+r2;
        return r1+r2;
    }
}