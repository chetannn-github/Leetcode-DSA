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


class Solution {
    List<List<List<Integer>>> adj;
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        this.adj = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(v).add(Arrays.asList(u,wt));
            max = Math.max(max,wt);
            min = Math.min(min,wt);
        }

        int start = min;
        int end = max;
        int ans = -1;

        while(end >= start){
            int mid = start + ((end - start)>>1);
            HashSet<Integer> visited = new HashSet<>();
            dfs(mid,0,visited);

            if(visited.size() == n){
                ans = mid;
                end = mid-1;
            }else {
                start = mid + 1;
            }
        }
        return ans;
    }


    public void dfs(int maxWt, int curr,HashSet<Integer> visited){
        visited.add(curr);

        for(List<Integer> nbr : adj.get(curr)){
            int v = nbr.get(0);
            int wt = nbr.get(1);

            if(wt <= maxWt && !visited.contains(v)){
                dfs(maxWt,v,visited);
            }
        }
    }
}