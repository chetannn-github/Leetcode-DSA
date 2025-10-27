class Solution {
    List<Integer>[] graph;

    public int findShortestCycle(int n, int[][] edges) {
        graph = buildGraph(edges, n);
        int ans = Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {
            int[] dist = new int[n];
            Arrays.fill(dist, -1);
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{start, -1});
            dist[start] = 0;

            while (!q.isEmpty()) {
                int[] curr = q.poll();
                int node = curr[0], parent = curr[1];

                for (int nbr : graph[node]) {
                    if (dist[nbr] == -1) {
                        dist[nbr] = dist[node] + 1;
                        q.offer(new int[]{nbr, node});
                    } else if (nbr != parent) {
                        ans = Math.min(ans, dist[node] + dist[nbr] + 1);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private List<Integer>[] buildGraph(int[][] edges, int n) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        return graph;
    }
}
