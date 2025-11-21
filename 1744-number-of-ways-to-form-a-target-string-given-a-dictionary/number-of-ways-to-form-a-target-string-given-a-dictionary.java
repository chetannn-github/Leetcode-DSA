class Solution {
    int N,K;
    Long[][] dp;
    HashMap<Integer,Integer>[] idxMap;
    String[] words; String target;
    int MOD = 1_000_000_007;
    public int numWays(String[] words, String target) {
        this.N = target.length();
        this.K = words[0].length();
        this.dp = new Long[K][N];
        this.idxMap = new HashMap[K];
        this.words = words;
        this.target = target;

        for(String word : words) {
            for(int i=0; i<K; i++) {
                if(idxMap[i] == null) idxMap[i] = new HashMap<>();
                int curr = (int) word.charAt(i) - 'a';
                HashMap<Integer,Integer> map = idxMap[i];
                map.put(curr, map.getOrDefault(curr,0)+1);
                idxMap[i] = map;
            } 
        }

        return (int) solve(0,0);
    }

    private long solve(int wordIdx, int targetIdx) {
        if(targetIdx >= N) return 1;
        if(wordIdx == K) return 0;
        if(dp[wordIdx][targetIdx] != null) return dp[wordIdx][targetIdx];
        int curr = (int) target.charAt(targetIdx) - 'a';

        long take = 0;
        if(idxMap[wordIdx].containsKey(curr)) {
            take = (idxMap[wordIdx].get(curr) * solve(wordIdx+1, targetIdx+1)% MOD) ;
            take %= MOD;
        }

        long skip = (solve(wordIdx+1,targetIdx) % MOD);

        return dp[wordIdx][targetIdx] = (take + skip) % MOD;
    }
}