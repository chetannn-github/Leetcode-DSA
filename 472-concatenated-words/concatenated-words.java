class Solution { 
    HashSet<String> s = new HashSet<>();
    Integer[][] dp;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        for(String word : words) s.add(word);
        for(String word : words) {
            int n = word.length();
            this.dp = new Integer[n+1][n+1];
            if(solve(word,0,0))
                result.add(word);
        }
        return result;
}
    public boolean solve(String word,int start, int end) {
        int n = word.length();
        boolean result = false;

        if(end == n) return start != 0 && s.contains(word.substring(start,end));
        if(dp[start][end] != null) return dp[start][end] == 1;

        result = result || solve(word,start,end+1);

        if(s.contains(word.substring(start,end+1))) {
            result = result || solve(word,end+1,end+1);
        }
        dp[start][end] = result ? 1 : 0;
        return result;




        
    }
}