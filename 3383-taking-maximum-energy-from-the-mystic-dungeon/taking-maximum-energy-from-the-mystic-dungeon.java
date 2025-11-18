class Solution {
    int N;
    int NOT_CACHED = Integer.MIN_VALUE;
    int[] energy, dp;
    public int maximumEnergy(int[] energy, int k) {
        this.N = energy.length;
        this.energy = energy;
        this.dp = new int[N];
        int maxEnergy = Integer.MIN_VALUE;

        Arrays.fill(dp,NOT_CACHED);
        for(int i= 0; i<N; i++) {
            maxEnergy = Math.max(maxEnergy,energy[i] + solve(i+k,k));

        }
        return maxEnergy;
    }

    private int solve(int currIdx, int k) {
        if(currIdx >= N) return 0;
        if(dp[currIdx] != NOT_CACHED) return dp[currIdx];

        return dp[currIdx] = energy[currIdx] + solve(currIdx+k,k);

        
    }
}