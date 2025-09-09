class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashSet<Integer>[] graph = new HashSet[n];
        int[] degree = new int[n];

        for(int i=0; i<n; i++) graph[i] = new HashSet<>();

        for(int[] road : roads) {
            int u = road[0], v = road[1];
            degree[u]++;
            degree[v]++;

            HashSet<Integer> nbr = graph[u];
            nbr.add(v);
            graph[u] = nbr;

            nbr = graph[v];
            nbr.add(u);
            graph[v] = nbr;

        }


        int result = 0;

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int sub = graph[i].contains(j) ? -1 : 0;
                int currRes = degree[i] + degree[j] +  sub;
                result = result > currRes ? result : currRes;
            }
        }
        
        return result;
    }
}