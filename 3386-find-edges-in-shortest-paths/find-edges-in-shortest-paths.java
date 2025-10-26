// class Solution {
//     List<Pair>[] graph;
//     public boolean[] findAnswer(int n, int[][] edges) {
//         boolean[] result = new boolean[edges.length];
//         HashMap<Triplet, Integer> edgesToIdx = new HashMap<>();
//         constructGraph(n, edges);
//         mapEdgesToIdx(edges, edgesToIdx);
        
//         HashSet<Integer>[] shortestPathEdgesIdx = dijkstra(n, edgesToIdx);
//         for(int i=0; i<edges.length; i++) {
//             result[i] = shortestPathEdgesIdx[n-1].contains(i);
//         }
//         return result;
//     }

//     private void constructGraph(int n, int[][] edges) {
//         this.graph = new List[n];

//         for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

//         for(int[] edge : edges) {
//             int u = edge[0], v = edge[1], wt = edge[2];
//             graph[u].add(new Pair(v,wt));
//             graph[v].add(new Pair(u,wt));
//         }
//     }

//     private void mapEdgesToIdx(int[][] edges, HashMap<Triplet, Integer> edgesToIdx) {
//         for(int i=0; i<edges.length; i++) {
//             int u = edges[i][0], v = edges[i][1], wt = edges[i][2];
//             Triplet key = new Triplet(u,v,wt);
//             edgesToIdx.put(key, i);
//             key = new Triplet(v,u,wt);
//             edgesToIdx.put(key, i);
//         }
//     }

//     private HashSet<Integer>[] dijkstra(int n,HashMap<Triplet, Integer> edgesToIdx) {
//         PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> (a.wt - b.wt));
//         int[] dist = new int[n];
//         HashSet<Integer>[] shortestPathEdgesIdx = new HashSet[n];
      
//         Arrays.fill(dist, Integer.MAX_VALUE);
//         dist[0] = 0;
//         pq.add(new Pair(0,0));

//         for(int i=0; i<n; i++) shortestPathEdgesIdx[i] = new HashSet<>();


//         while(!pq.isEmpty()) {
//             Pair curr = pq.remove();
//             int u = curr.node, wt = curr.wt;
//             if(wt > dist[u]) continue;

//             for(Pair nbr : graph[u]) {
//                 int v = nbr.node, nbrWt = nbr.wt;
//                 if(wt + nbrWt < dist[v]) {
//                     Triplet key = new Triplet(u,v,nbrWt);
//                     int edgeIdx = edgesToIdx.get(key);
//                     shortestPathEdgesIdx[v] = new HashSet<>();
//                     shortestPathEdgesIdx[v].add(edgeIdx);

//                     for(int idx : shortestPathEdgesIdx[u]) {
//                         shortestPathEdgesIdx[v].add(idx);
//                     }

//                     dist[v] = nbrWt + wt;
//                     pq.add(new Pair(v, dist[v]));
//                 }else if(wt + nbrWt == dist[v]) {
//                     Triplet key = new Triplet(u,v,nbrWt);
//                     int edgeIdx = edgesToIdx.get(key);
//                     shortestPathEdgesIdx[v].add(edgeIdx);
//                     for(int idx : shortestPathEdgesIdx[u]) {
//                         shortestPathEdgesIdx[v].add(idx);
//                     }
//                 }
//             }
//         }

//         return shortestPathEdgesIdx;
//     }
// }


class Pair {
    int node, wt;
    Pair(int node, int wt) {
        this.node = node; 
        this.wt = wt;
    }
}

// class Triplet {
//     int u,v,wt;
//     Triplet(int u,int v,int wt){ this.u=u; this.v=v; this.wt=wt; }

//     @Override
//     public int hashCode(){
//         return Objects.hash(u,v,wt);
//     }

//     @Override
//     public boolean equals(Object o) {
//         Triplet t = (Triplet) o;
//         return u == t.u && v == t.v && wt == t.wt;
//     }
// }



class Solution {
    List<Pair>[] graph;
    int MAX = Integer.MAX_VALUE;
    public boolean[] findAnswer(int n, int[][] edges) {
        boolean[] result = new boolean[edges.length];
        buildGraph(n, edges);

        int[] dist1 = dijkstra(0, n);
        int[] dist2 = dijkstra(n-1, n);
        int shortest = dist1[n-1];

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            boolean isPart = (
                (dist1[u] != MAX && dist2[v] != MAX && dist1[u] + w + dist2[v] == shortest)
                || 
                (dist2[u] != MAX && dist1[v] != MAX && dist1[v] + w + dist2[u] == shortest)
            );

            result[i] = isPart;
            
        }
        return result;
    }

    private void buildGraph(int n, int[][] edges) {
        this.graph = new List[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            graph[u].add(new Pair(v,wt));
            graph[v].add(new Pair(u,wt));
        }
    }

    private int[] dijkstra(int src, int n) {
        int[] dist = new int[n]; 
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.wt - b.wt);

        Arrays.fill(dist, MAX);
        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (curr.wt > dist[curr.node]) continue;

            for (Pair nbr : graph[curr.node]) {
                int newDist = curr.wt + nbr.wt;
                if (newDist < dist[nbr.node]) {
                    dist[nbr.node] = newDist;
                    pq.add(new Pair(nbr.node, newDist));
                }
            }
        }
        return dist;
    }
}
