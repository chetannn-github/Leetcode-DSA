// class Solution {
//     HashMap<Integer,List<Integer>> adj;
//     HashSet<Integer> visited;
//     public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
//         adj = new HashMap<>();
//         visited = new HashSet<>();

//         for(int[] edge : edges){
//             List<Integer> nbr = adj.getOrDefault(edge[0],new ArrayList<>());
//             nbr.add(edge[1]);
//             adj.put(edge[0],nbr);

//             nbr = adj.getOrDefault(edge[1],new ArrayList<>());
//             nbr.add(edge[0]);
//             adj.put(edge[1],nbr);
//         }
//         int ans = dfs(0,hasApple);

//         return ans > 0 ? ans-2 : 0 ;
            
//     }


//     public int dfs(int curr,List<Boolean> hasApple){
//         visited.add(curr);
//         int time = 0;

//         for(Integer nbr : adj.getOrDefault(curr,new ArrayList<>())){
//             if(!visited.contains(nbr)){
//                 time += dfs(nbr,hasApple);
//             }
//         }

//         if(hasApple.get(curr)){
//             time +=2;
//         }else if(time!=0){
//             time +=2;
//         }

//         return time;
//     }
// }


class Solution {
    HashSet<Integer> visited;
    List<Integer>[] graph;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        constructGraph(n,edges);
        visited = new HashSet<>();
        int res = dfs(0,hasApple);
        return res < 0 ? 0 : res ;
    }


    public int dfs(int curr,List<Boolean> hasApple){
        visited.add(curr);
        int time = 0;

        for(Integer nbr : graph[curr]){
            if(!visited.contains(nbr)){
                int res = dfs(nbr,hasApple);
                time += res < 0 ?  0 : res + 2;
            }
        }

        if(time == 0 && !hasApple.get(curr)) {
            return -1;
        }
    

        return time;
    }

    public void constructGraph(int n, int[][] edges) {
        graph = new List[n];
        visited = new HashSet<>();

        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            List<Integer> nbr = graph[u];
            nbr.add(v);
            graph[u] = nbr;

            nbr = graph[v];
            nbr.add(u);
            graph[v] = nbr;

        }
    }
}