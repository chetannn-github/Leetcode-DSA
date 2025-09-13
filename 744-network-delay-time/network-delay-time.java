class Solution {
    public int networkDelayTime(int[][] times, int n, int source) {
        List<Node>[] graph = constructGraph(times,n+1);
        int[] minDelayFromSource = dijkstra(graph, source, n+1);
        
        int maxDelay = findMaxOfArray(minDelayFromSource);
        return  maxDelay == Integer.MAX_VALUE ? -1 : maxDelay;
    }

    public List<Node>[] constructGraph(int[][] edges, int n) {
        List<Node>[] graph = new List[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            graph[u].add(new Node(v, wt));
        }
        return graph;
    }

    public int[] dijkstra(List<Node>[] graph, int source, int n) {
        int[] minDistanceFromSrc = new int[n];
        Arrays.fill(minDistanceFromSrc, Integer.MAX_VALUE);
       
        minDistanceFromSrc[source] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Pair(0, source));
        int max = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int d = curr.dist;
            int u = curr.node;

            if (d > minDistanceFromSrc[u]) continue;

            for (Node neighbor : graph[u]) {
                int v = neighbor.v;
                int wt = neighbor.wt;

                if (d + wt < minDistanceFromSrc[v]) {
                    minDistanceFromSrc[v] = d + wt;
                    pq.add(new Pair(minDistanceFromSrc[v], v));
                }
            }
        }

        return minDistanceFromSrc;
    }

    public int findMaxOfArray(int[] arr) {
        int maxVal = Integer.MIN_VALUE;

        for(int i = 1; i<arr.length; i++) {
            maxVal = Math.max(maxVal, arr[i]);
        }
        return maxVal;
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