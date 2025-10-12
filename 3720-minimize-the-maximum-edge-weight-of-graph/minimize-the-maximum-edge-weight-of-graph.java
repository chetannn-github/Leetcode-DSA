// class Solution {
//     public int minMaxWeight(int n, int[][] edges, int threshold) {
//         int[][] dist = new int[n][n];

//         for(int i=0; i<n; i++){
//             for(int j=0; j<n; j++){
//                 if(i == j) dist[i][j] = 0;
//                 else dist[i][j] = Integer.MAX_VALUE;
//             }
//         }
//         for(int[] edge : edges){
//             if(dist[edge[0]][edge[1]] > edge[2]){
//                 dist[edge[0]][edge[1]] = edge[2];
//             }
//         }

//         for(int via = 0; via<n; via++){
//             for(int i=0; i<n; i++){
//                 for(int j=0;j<n; j++){
//                     if(Math.max(dist[i][via], dist[via][j]) < dist[i][j]){
//                         dist[i][j] = Math.max(dist[i][via], dist[via][j]);
//                     }
//                 }

//             }
//         }

//         int max = Integer.MIN_VALUE;

//         for(int i=0; i<n; i++){
//             int j=0;
//             max = Math.max(dist[i][j],max);
//         }

//         return max == Integer.MAX_VALUE ? -1 : max;
//     }
// }


// class Solution {
//     List<Node>[] graph;
//     int start,end;
//     public int minMaxWeight(int n, int[][] edges, int threshold) {
//         constructReverseGraphAndFindMaxAndMinEdge(n,edges);
//         int ans = -1;

//         while(end >= start){
//             int mid = start + ((end - start)>>1);
//             HashSet<Integer> visited = new HashSet<>();
//             dfs(mid,0,visited);

//             if(visited.size() == n){
//                 ans = mid;
//                 end = mid-1;
//             }else {
//                 start = mid + 1;
//             }
//         }
//         return ans;
//     }


//     public void dfs(int maxWt, int curr,HashSet<Integer> visited){
//         visited.add(curr);

//         for(Node nbr : graph[curr]){
//             int v = nbr.node;
//             int wt = nbr.wt;

//             if(wt <= maxWt && !visited.contains(v)){
//                 dfs(maxWt,v,visited);
//             }
//         }
//     }

//     public void constructReverseGraphAndFindMaxAndMinEdge(int n, int[][] edges) {
//         start = Integer.MAX_VALUE;
//         end = Integer.MIN_VALUE;
//         this.graph = new List[n];
//         for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

//         for(int[] edge : edges){
//             int u = edge[0];
//             int v = edge[1];
//             int wt = edge[2];

//             graph[v].add(new Node(u,wt));
//             end = Math.max(end,wt);
//             start = Math.min(start,wt);
//         }
//     }
// }
 
// class Node {
//     int node,wt;
//     Node(int node, int wt) {
//         this.node = node;
//         this.wt = wt;
//     }
// }


class Solution {
    List<Node>[] graph;

    public int minMaxWeight(int n, int[][] edges, int threshold) {
        buildReverseGraph(n, edges);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        dist[0] = 0;
        pq.offer(new int[]{0, 0});

        while(!pq.isEmpty()){
            int[] top = pq.remove();
            int u = top[0];
            int currMax = top[1];

            if(currMax > dist[u]) continue;

            for(Node nbr : graph[u]){
                int v = nbr.node;
                int wt = nbr.wt;

                int newMax = Math.max(currMax, wt);

                if(newMax < dist[v]){
                    dist[v] = newMax;
                    pq.add(new int[]{v, newMax});
                }
            }
        }

        int ans = -1;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, dist[i]);
            if(ans == Integer.MAX_VALUE) return -1;
        }
        return ans;
    }

    private void buildReverseGraph(int n, int[][] edges){
        graph = new List[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] e : edges){
            int u = e[0], v = e[1], w = e[2];
            graph[v].add(new Node(u, w));
        }
    }
}

class Node {
    int node, wt;
    Node(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}
