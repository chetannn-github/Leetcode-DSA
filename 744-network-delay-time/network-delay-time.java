class Solution {
    public int networkDelayTime(int[][] times, int n, int source) {
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        HashMap<Integer,List<List<Integer>>> adj = new HashMap<>();

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int wt = time[2];
            List<Integer> ls = new ArrayList<>();
            ls.add(v);
            ls.add(wt);
            List<List<Integer>> neighbor = adj.getOrDefault(u,new ArrayList<>());
            neighbor.add(ls);
            adj.put(u,neighbor);
        }
        dist[source] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        pq.add(new int[]{0,source});
        int max = 0;


        while(!pq.isEmpty()){
            int curr[] = pq.remove();
            int d = curr[0];
            int u = curr[1];

            if(d > dist[u]) continue;
            if(!adj.containsKey(u)) continue;

            for(List<Integer> ls : adj.get(u)){
                int v = ls.get(0);
                int wt = ls.get(1);

                if(d + wt < dist[v]){
                    dist[v] = d + wt;
                    pq.add(new int[]{dist[v],v});
                    
                }

            }
        }


        for(int i=1; i<=n; i++){
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(dist[i], max);
        }


        return max;
        
    }

}