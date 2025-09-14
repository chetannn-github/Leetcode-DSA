class Solution {
    int MOD = 1_000_000_007;
    long[] dp;
    int[] minDistanceFromEnd;
    public int countRestrictedPaths(int n, int[][] edges) {
        List<Node>[] graph = constructGraph(edges, n+1);
        minDistanceFromEnd = dijkstraAlgo(n, graph, n+1);

        dp = new long[n+1];
        Arrays.fill(dp,-1);
        long result = (long) solve(1, n, graph) % MOD;
        return (int) result;
    
    }

    private int[] dijkstraAlgo(int src, List<Node>[] graph, int n) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.dist - b.dist));
        pq.add(new Pair(src,0));
        distance[src] = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int dist = curr.dist;
            int u = curr.node;

            if(distance[u] < dist) continue;

            for(Node nbr : graph[u]) {
                int v = nbr.v;
                int wt =nbr.wt;
                if(wt + dist < distance[v]) {
                    pq.add(new Pair(v, wt + dist));
                    distance[v] = wt + dist;
                }
            }
        }
        return distance;

    }

    private long solve(int curr, int n, List<Node>[] graph) {
        if(dp[curr] != -1) {
            return dp[curr];
        }
        if(curr == n) return 1L;
        long result = 0L;

        for(Node nbr : graph[curr]) {
            int v = nbr.v;
            if(v == n) result += 1;
            else if(minDistanceFromEnd[v] < minDistanceFromEnd[curr]) {
                result += solve(v, n ,graph);
            }
        }

        return dp[curr] = result % MOD;
    }

    private List<Node>[] constructGraph(int[][] edges, int n) {
        List<Node>[] graph = new List[n];
        for(int i = 0; i<n; i++) graph[i]= new ArrayList<>();

        for(int[] edge : edges) {
            int u = edge[0] , v = edge[1], wt = edge[2];
            graph[u].add(new Node(v,wt));
            graph[v].add(new Node(u,wt));
        }

        return graph;
    }
}


class Node {
    int v, wt;
    Node(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}

class Pair {
    int dist, node;
    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}