class Solution {
    HashSet<String> words;
    int N;
    int[][] dp;
    public int minExtraChar(String s, String[] dictionary) {
        words = new HashSet<>();
        N = s.length();
        dp = new int[N][N];
        for(int[] row : dp) Arrays.fill(row,-1);

        for(String word : dictionary) words.add(word);

        return (int) solve(s,0,0);

    }

    public int solve(String s, int start, int curr) {
        if(curr == N-1) {
            if(words.contains(s.substring(start,curr + 1))) {
                return 0;
            }else return curr - start + 1;
        }

        if (dp[start][curr] != -1 ) return dp[start][curr];

        int result = Integer.MAX_VALUE;
        if(words.contains(s.substring(start,curr + 1))) {
            result = solve(s,curr+1,curr+1);
            
        } 

        int skip =  curr - start + 1 + solve(s,curr+1, curr + 1);
        int take =  solve(s,start, curr+1);

        return dp[start][curr] = Math.min(skip, Math.min(take, result));
        



    } 
}