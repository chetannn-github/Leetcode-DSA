// class Solution {
//     public int[] countOfPairs(int n, int x, int y) {
//         int[][] dist = new int[n][n];

//         for(int i=0; i<n; i++){
//             for(int j=0; j<n; j++){
//                 dist[i][j] = Math.abs(i-j);
//             }
//         }
//         if(x != y ){
//             dist[x-1][y-1] = 1;
//             dist[y-1][x-1] = 1;
//         }
        


//         for(int via = 0; via <n; via++){
//             for(int i=0; i<n; i++){
//                 for(int j=0; j<n; j++){
//                     if(dist[i][via] + dist[via][j] < dist[i][j]){
//                         dist[i][j] = dist[i][via] + dist[via][j];
//                     }
//                 }
//             }
//         }

//         int ans[] = new int[n];
//         for(int i=0; i<n; i++){
//             for(int j=0; j<n; j++){
//                 if(dist[i][j] == 0) continue;
//                 ans[dist[i][j]-1]++;
//             }
//         }

//         return ans;
//     }
// }


class Solution {
    int result[];
    List<List<Integer>> adj;
    public int[] countOfPairs(int n, int x, int y) {
        result = new int[n];
        adj = new ArrayList<>();

        for(int i=0; i<n; i++) {
            List<Integer> nbr = new ArrayList<>();
            if(x != y) {
                if(i == x-1) nbr.add(y-1);
                if(i == y-1) nbr.add(x-1);
            }
            if(i<n-1) nbr.add(i+1);
            if(i>0)  nbr.add(i-1);
            adj.add(nbr);
        }
        
        // System.out.println(adj.toString());
        for(int i=0; i<n; i++) {
            bfs(i);
        }

        return result;
    }

    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>(); 
        queue.add(start); 
        visited.add(start);

        int count = 0;

        while(!queue.isEmpty()) {
            int n = queue.size();

            while(n-->0) {
                int curr = queue.remove();
                
                for(int nbr : adj.get(curr)) {
                    if(!visited.contains(nbr)) {
                        queue.add(nbr);
                        visited.add(nbr);
                    }
                }
                
            }
            
            result[count++] += queue.size();
        }
    }
}
