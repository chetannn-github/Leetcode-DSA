class Solution {
    int MOD = 1_000_000_007;
    
    public int countPaths(int n, int[][] roads) {
        List<Node>[] graph = new List[n];
        constructGraph(graph,roads,n);
        return dijkstra(graph,n);

        
    }

    private void constructGraph( List<Node>[] graph, int[][] edges, int n) {
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            graph[u].add(new Node(v, wt));
            graph[v].add(new Node(u, wt));
        }
    }

    private int dijkstra(List<Node>[] graph, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        pq.add(new Pair(0, 0));  //  node,dist

        long[] dist = new long[n];
        long[] count = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        count[0] = 1;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            long wt = curr.dist;

            if (wt > dist[u]) continue;

            for (Node neighbor : graph[u]) {
                int v = neighbor.v;
                int nbrCost = neighbor.wt;

                if (wt + nbrCost < dist[v]) {
                    dist[v] = wt + nbrCost;
                    count[v] = count[u];
                    pq.add(new Pair(dist[v], v));
                } else if (wt + nbrCost == dist[v]) {
                    count[v] = (count[v] + count[u]) % MOD;
                }
            }
        }

        return (int) (count[n - 1] % MOD);
    }
}




class Node {
    int v;
    int wt;

    Node(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}

class Pair {
    long dist;
    int node;

    Pair(long dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}
