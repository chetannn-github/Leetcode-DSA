class Solution {
    List<Integer>[] graph;
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        graph = new List[n];

        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] edge : edges) {
            int u = edge[0]-1, v = edge[1]-1;
            graph[u].add(v);
            graph[v].add(u);
        }

        
        return dijkstra(0,time,change,n);
    }

    private int dijkstra(int src, int time, int change, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.wt - b.wt));
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        pq.add(new Pair(src,0));
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[src] = 0;


        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            int u = curr.node, wt = curr.wt;
            if(dist2[n-1] != Integer.MAX_VALUE) return dist2[n-1];

            for(int nbr : graph[u]) {
                int nbrWt = wt + time;
                boolean oddDiv = ((wt / change) & 1) == 1;
                if(oddDiv) nbrWt = time + change * ((wt/change) + 1);
                
                if(dist1[nbr] > nbrWt) {
                    dist1[nbr] = nbrWt;
                    pq.add(new Pair(nbr,dist1[nbr]));
                }

                else if(nbrWt != dist1[nbr] && dist2[nbr] > nbrWt) {
                    dist2[nbr] = nbrWt;
                    pq.add(new Pair(nbr,dist2[nbr]));
                }
            }
        }

        return -1;
    }
}

class Pair {
    int node, wt;
    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}

