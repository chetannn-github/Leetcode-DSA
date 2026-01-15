class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = 1_000_000_007;
        int[][] mat = new int[n][2];

        for(int i=0; i<n; i++) {
            mat[i][0] = speed[i];
            mat[i][1] = efficiency[i];
        }

        Arrays.sort(mat,(a,b)->(b[1]-a[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long kSum = 0;
        long maxPerf = 0;

        for(int i=0; i<n; i++) {
            long currSpeed = (long) mat[i][0];
            long currEff = (long) mat[i][1];
            
            kSum += currSpeed;
            pq.add(mat[i][0]);

            if(pq.size() > k) {
                kSum -= pq.remove();
            }
            
            long curr = (kSum * currEff);
            maxPerf = Math.max(maxPerf, curr);
        }

        return (int) (maxPerf % MOD);
    }
}