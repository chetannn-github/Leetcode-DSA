class Graph {
    int[][] dist;
    int n;
    public Graph(int n, int[][] edges) {
        this.n = n;
        dist = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                dist[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            dist[u][v] = wt;
        }
        floydWarshall();
    }
    
    public void addEdge(int[] edge) {
        int u = edge[0], v = edge[1], wt = edge[2];
        if(dist[u][v] < wt) return;
        dist[u][v] = wt;

         for(int i=0; i<n;i++) {
            for(int j=0; j<n; j++) {
                boolean isConnected = (
                    dist[i][u] != Integer.MAX_VALUE && dist[v][j] != Integer.MAX_VALUE
                );

                // i to u to v to j
                boolean isOptimal = isConnected && dist[i][j] > dist[i][u] + wt + dist[v][j];
                if(isOptimal) dist[i][j] = dist[i][u] + wt + dist[v][j];
            }
        } 
        
    }
    
    public int shortestPath(int u, int v) {
        return dist[u][v] == Integer.MAX_VALUE ? -1 : dist[u][v];
    }

    public void floydWarshall() {
        for(int via = 0; via < n; via++) {
            for(int i=0; i<n;i++) {
                for(int j=0; j<n; j++) {
                    boolean isConnected = (
                        dist[i][via] != Integer.MAX_VALUE && dist[via][j] != Integer.MAX_VALUE
                    );
                    boolean isOptimal = isConnected && dist[i][j] > dist[i][via] + dist[via][j];
                    if(isOptimal) dist[i][j] = dist[i][via] + dist[via][j];
                }
            } 
        }
    }
}

