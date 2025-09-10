// class Solution {
//     public int findTheCity(int n, int[][] edges, int distMax) {
//         int[][] dist = new int[n][n];

//         for(int[] row : dist){
//             Arrays.fill(row,Integer.MAX_VALUE);
//         }

//         for(int[] edge : edges){
//             dist[edge[0]][edge[1]] = edge[2];
//             dist[edge[1]][edge[0]] = edge[2];
//         }

//         for(int via =0; via<n; via++){
//             for(int i=0; i<n; i++){
//                 for(int j=0; j<n; j++){
//                     if(i == j){ 
//                         dist[i][j] = 0;
//                         continue;
//                     }
//                     if(dist[i][via] != Integer.MAX_VALUE && dist[via][j] != Integer.MAX_VALUE){
//                         if(dist[i][via] + dist[via][j] < dist[i][j]){
//                             dist[i][j] = dist[i][via] + dist[via][j];
//                         }
//                     }
//                 }
//             }
//         }
//         int minCount = n;
//         int ans = 0;

//         for(int i=0; i<n; i++){
//             int count = 0;
//             for(int j=0; j<n; j++){
//                 if(i != j && dist[i][j] <= distMax) count++;
//             }
            
//             if(minCount >= count){
//                 minCount = count;
//                 ans = i;
//             }
//         }

//         return ans;
//     }
// }


class Solution {
    List<Node>[] graph;
    public int findTheCity(int n, int[][] edges, int distMax) {
        constructGraph(n,edges);

        int minNbrs = n;
        int minNbrsCity = 0;
        for(int i=0; i<n; i++) {
            int nbrs = calculateNbrs(i, distMax,n);
            if(minNbrs >= nbrs) {
                minNbrs = nbrs;
                minNbrsCity = i;
            }
        }

        return minNbrsCity;
    }


    public void constructGraph(int n, int[][] edges) {
        graph = new List[n];

        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            graph[u].add(new Node(v,wt));
            graph[v].add(new Node(u,wt));
        }

    }


    public int calculateNbrs(int src, int distMax, int n) {
        int nbrs = 0;

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->(a.wt - b.wt));
        pq.add(new Node(src, 0));


        while(!pq.isEmpty()) {
            Node curr = pq.remove();
            int u = curr.v;
            int wt = curr.wt;

            if(dist[u] < wt) continue;

            for(Node nbr : graph[u]) {
                int v = nbr.v;
                int nbrWt = nbr.wt;

                if(nbrWt + wt < dist[v]) {
                    dist[v] = nbrWt + wt;
                    pq.add(new Node(v,dist[v]));
                }
            }
        }

        for(int i=0; i<n; i++) {
            if(i!= src && dist[i] <= distMax) nbrs++;
        }


        return nbrs;
    }
}


class Node {
    int v, wt;
    Node (int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}