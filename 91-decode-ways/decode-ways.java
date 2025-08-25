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


    public int solve(String s, int curr) {
        if(curr >= n ) return 1;
        if(dp[curr] != - 1) return dp[curr];

        int takeOne = 0, takeTwo = 0;
        char currChar = s.charAt(curr);
        if(hs.contains(currChar + "")) {
            takeOne = solve(s,curr + 1);
        }

        if(curr + 1 != n) {
            String key = currChar + "" + s.charAt(curr + 1);
            if(hs.contains(key)) {
                takeTwo = solve(s, curr+2);
            }
        }

        return dp[curr] = takeOne + takeTwo;

    }
}