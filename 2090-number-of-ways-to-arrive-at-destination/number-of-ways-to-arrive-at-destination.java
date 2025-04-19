class Solution {
    int mod = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        List<List<List<Integer>>> adj = new ArrayList<>();

        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] road : roads){
            adj.get(road[0]).add(Arrays.asList(road[1],road[2]));
            adj.get(road[1]).add(Arrays.asList(road[0],road[2]));
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->(a[0] - b[0] > 0 ? 1 : -1));
        pq.add(new long[]{0,0}); // wt , u
        long[] count = new long[n];
        long[] dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;
        count[0] = 1;

        while(!pq.isEmpty()){
            long curr[] = pq.remove();
            long u = curr[1];
            long wt = curr[0];

            for(List<Integer> nbr : adj.get((int)u)){
                int v = nbr.get(0);
                int cost = nbr.get(1);

                if((long)cost + wt < dist[v]){
                    dist[v] = (long)cost + wt;
                    pq.add(new long[]{dist[v],v});
                    count[v] = count[(int) u];
                }else if(cost + wt == dist[v]){
                    count[v] += count[(int) u];
                    count[v] %=mod;
                }
            }
        }

        return (int) count[n-1] % mod;
    }
}