class Solution {
    public int networkDelayTime(int[][] times, int n, int source) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        List<List<Node>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] time : times) {
            int u = time[0], v = time[1], wt = time[2];
            adj.get(u).add(new Node(v, wt));
        }

        dist[source] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Pair(0, source));
        int max = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int d = curr.dist;
            int u = curr.node;

            if (d > dist[u]) continue;

            for (Node neighbor : adj.get(u)) {
                int v = neighbor.v;
                int wt = neighbor.wt;

                if (d + wt < dist[v]) {
                    dist[v] = d + wt;
                    pq.add(new Pair(dist[v], v));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
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
        Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }