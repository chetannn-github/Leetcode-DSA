class Solution {
    int[] freq = new int[26];
    int n;
    int[] score;
    String[] words;
    HashMap<String,Integer>[] dp;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.n = words.length;
        this.score = score;
        this.words = words;
        this.dp = new HashMap[n];
        
        for(char ch : letters) {
            freq[ch-'a']++;
        }

        for(int i=0; i<n; i++) dp[i] = new HashMap<>();

        return solve(0);
    }

    private int solve(int currIdx) {
        if(currIdx >= n) return 0;
        String key = Arrays.toString(freq);
        if(dp[currIdx].containsKey(key)) {
            return dp[currIdx].get(key);
        }

        int take = 0;
        int takeScore = 0;
        boolean canTake = true;
        for(char ch : words[currIdx].toCharArray()) {
            takeScore += score[ch-'a'];
            freq[ch-'a']--;
            if(freq[ch-'a'] < 0) canTake = false;
        }
        if(canTake) {
            take = takeScore + solve(currIdx+1);
        } 

        for(char ch : words[currIdx].toCharArray()) {
            freq[ch-'a']++;
        }  

        int skip = solve(currIdx+1);
        dp[currIdx].put(key,Math.max(take,skip));
        return Math.max(take,skip);
    }

}