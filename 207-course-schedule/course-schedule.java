// class Solution {
//     // all i need to find cycle in directed graph
//     HashMap<Integer,List<Integer>> adj;
//     HashSet<Integer> visited;
//     HashSet<Integer> currRecursion;
    
//     public boolean canFinish(int numCourses, int[][] pre) {
//         adj = new HashMap<>();
//         visited = new HashSet<>();
//         currRecursion = new HashSet<>();

//         for(int[] relation : pre){
//             List<Integer> nodes = adj.getOrDefault(relation[1], new ArrayList<>());
//             nodes.add(relation[0]);
//             adj.put(relation[1],nodes);
//         }


//         for(int node : adj.keySet()){
//             if(!visited.contains(node) && !checkCycle(node)){
//                 return false;
//             }
//         }
//         return true;
        
//     }


//     public boolean checkCycle(int currNode){
//         visited.add(currNode);
//         currRecursion.add(currNode);

//         for(int neighbour : adj.getOrDefault(currNode, new ArrayList<>())){
//             if(! visited.contains(neighbour) && !checkCycle(neighbour)){
//                 return false;
//             }else if(currRecursion.contains(neighbour)){
//                 return false;
//             }

//         }

//         currRecursion.remove(currNode);

//         return true;
//     }
// }
class Solution {
    // all i need to find cycle in directed graph
    List<Integer>[] graph;
    HashSet<Integer> visited;
    boolean[] bl;
    
    public boolean canFinish(int numCourses, int[][] pre) {
        graph = new List[numCourses];
        visited = new HashSet<>();
        
        for(int[] relation : pre){
            int u = relation[1];
            int v = relation[0];
            List<Integer> nbrs = graph[u] == null ? new ArrayList<>() : graph[u];
            nbrs.add(v);
            graph[u] = nbrs;
        }

        return eventualSafeNodes(graph);
    }


    public boolean eventualSafeNodes(List<Integer>[] graph) {
        bl = new boolean[graph.length];
        
        for(int i=0; i<graph.length; i++){
            if(!visited.contains(i)){
                if(!dfs(graph,i)) return false;
            }
        }

        return true;
    }

    public boolean dfs(List<Integer>[] graph, int src){
        visited.add(src);
        boolean ans = true;
        if(graph[src] == null) return bl[src] = true;

        for(int nbr : graph[src]){
            if(!visited.contains(nbr)){
                ans = ans && dfs(graph,nbr);
            }else {
                ans = ans && bl[nbr];
            }

            if(!ans) return bl[src] = false;
        }

        return bl[src] = ans;
    }
}


