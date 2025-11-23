class Solution {
    int n, goal,k;
    int MOD = 1_000_000_007;
    Long[][] dp;
    public int numMusicPlaylists(int n, int goal, int k) {
        this.n = n; this.goal = goal; this.k = k;
        this.dp = new Long[goal][goal];
        return (int) solve(0,0);
    }


    private long solve(int songsAdded, int uniqueAdded) {
        if(songsAdded == goal) return uniqueAdded == n ? 1 : 0;
        if(dp[songsAdded][uniqueAdded] != null) return dp[songsAdded][uniqueAdded];

        int uniqueSongsLeft = n - uniqueAdded;
        long result = 0;
        if(uniqueSongsLeft > 0) {
            result = (uniqueSongsLeft * solve(songsAdded+1, uniqueAdded+1) % MOD);
            result %= MOD;
        }

        int replaySongsOptions = uniqueAdded - k;

        if(replaySongsOptions > 0) {
            result = result + (replaySongsOptions * solve(songsAdded+1 , uniqueAdded) % MOD);
            result %= MOD;
        }

        return dp[songsAdded][uniqueAdded] =  (result % MOD);

    }
}