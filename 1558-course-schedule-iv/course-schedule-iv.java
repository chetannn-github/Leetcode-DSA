// class Solution {
//     List<List<Integer>> adj;
//     public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] queries) {
//         adj = new ArrayList<>();

//         for(int i=0; i<n; i++) adj.add(new ArrayList<>());

//         for(int[] edge : pre){
//             adj.get(edge[0]).add(edge[1]);
//         }

//         List<Boolean> results = new ArrayList<>();
        
//         for(int[] q : queries){
//             results.add(bfs(q[0], q[1]));
//         }

//         return results;
//     }

//     public boolean bfs(int s, int e){
//         Queue<Integer> queue = new LinkedList<>();
//         HashSet<Integer> visited = new HashSet<>();

//         queue.add(s);
//         visited.add(s);

//         while(!queue.isEmpty()){
//             int curr = queue.remove();

//             if(curr == e) return true;

//             for(int nbr : adj.get(curr)){
//                 if(!visited.contains(nbr)){
//                     queue.add(nbr);
//                     visited.add(nbr);
//                 }
//             }
            
//         }

//         return false;
//     }
// }


class Solution {
    List<List<Integer>> adj;
    int INTMAX = Integer.MAX_VALUE;
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] queries) {
        adj = new ArrayList<>();
        int[][] distance = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(distance[i], INTMAX);

        for(int[] edge : pre){
            int u = edge[0], v = edge[1];
            distance[u][v] = 1;
        }

        for(int via = 0; via < n ; via++){
            for(int start = 0; start<n; start++) {
                for(int end = 0; end<n; end++) {
                    if(start == end) {
                        distance[start][start] = 0;
                        continue;
                    }
                    boolean safetyChecks =  distance[start][via] != INTMAX  && distance[via][end] != INTMAX;
                    boolean isBetter = safetyChecks && distance[start][via] + distance[via][end] < distance[start][end];
                    if (isBetter) {
                        distance[start][end] = distance[start][via] + distance[via][end];
                    }
                }
            }
        }

        List<Boolean> results = new ArrayList<>();
        
        for(int[] q : queries){
            results.add(distance[q[0]][q[1]] != INTMAX);
        }

        return results;
    }


}