class Solution {
    int MOD = 1_000_000_007;
    int[] distance;
    long[] dp;
    
    public int countRestrictedPaths(int n, int[][] edges) {
        distance = new int[n + 1];
        List<List<Node>> adj = new ArrayList<>();
        for(int i = 0; i<=n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges) {
            int u = edge[0] , v = edge[1], wt = edge[2];
            adj.get(u).add(new Node(v,wt));
            adj.get(v).add(new Node(u,wt));
        }

        dijkstraAlgo(n, adj, distance);
        dp = new long[n+1];
        Arrays.fill(dp,-1);
        long result = (long) solve(1, n, adj) % MOD;
        return (int) result;
    
    }

    private void dijkstraAlgo(int n, List<List<Node>> adj, int[] distance) {
        
        
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.dist - b.dist));
        pq.add(new Pair(n,0));
        distance[n] = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int dist = curr.dist;
            int u = curr.node;

            if(distance[u] < dist) continue;

            for(Node nbr : adj.get(u)) {
                int v = nbr.v;
                int wt =nbr.wt;
                if(wt + dist < distance[v]) {
                    pq.add(new Pair(v, wt + dist));
                    distance[v] = wt + dist;
                }
            }
        }
        return ;

    }

    private long solve(int curr, int n, List<List<Node>> adj) {
        if(dp[curr] != -1) {
            return dp[curr];
        }
        if(curr == n) return 1L;
        long result = 0L;

        for(Node nbr : adj.get(curr)) {
            int v = nbr.v;
            if(v == n) result += 1;
            else if(distance[v] < distance[curr] && distance[v] > 0) {
                result += solve(v, n ,adj);
            }
        }

        return dp[curr] = result % MOD;
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