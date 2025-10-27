class Solution {
    List<Pair>[] graph;
    int MAX = Integer.MAX_VALUE;
    private void buildGraph(int n, int[][] edges) {
        this.graph = new List[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            if(wt == -1) continue;
            graph[u].add(new Pair(v,wt));
            graph[v].add(new Pair(u,wt));
        }
    }

    private int dijkstra(int[][] edges, int n, int src, int dest) {
        buildGraph(n,edges);
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
        return dist[dest];
    }

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        int currShortestDist = dijkstra(edges, n, source, destination);

        if (currShortestDist < target) {
            return new int[][]{};
        }

        boolean matchedTarget = (currShortestDist == target);

        for (int[] edge : edges) {
            if(edge[2] == -1) {
                edge[2] = matchedTarget ? target : 1;

                if (!matchedTarget) {
                    int newShortestDist = dijkstra(edges, n, source, destination);

                    if (newShortestDist <= target) {
                        matchedTarget = true;
                        edge[2] += (target - newShortestDist);
                    }
                }
            }
        }

        if (!matchedTarget) {
            return new int[][]{};
        }
        return edges;
    }
}


class Pair {
    int node, wt;
    Pair(int node, int wt) {
        this.node = node; 
        this.wt = wt;
    }
}
