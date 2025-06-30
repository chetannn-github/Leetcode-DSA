// class Solution {
//     HashMap<Integer,List<Integer>> adj;
//     HashSet<Integer> visited;

//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         adj = new HashMap<>();
//         visited = new HashSet<>();

//         for(int[] edge : edges){
//             List<Integer> nodes = adj.getOrDefault(edge[0] , new ArrayList<>());
//             nodes.add(edge[1]);
//             adj.put(edge[0] , nodes);
            
//             nodes = adj.getOrDefault(edge[1] , new ArrayList<>());
//             nodes.add(edge[0]);
//             adj.put(edge[1] , nodes);
//         }

//         return dfs(source, destination);
//     }


//     public boolean dfs(int currNode, int destination){
//         visited.add(currNode);

//         if(currNode == destination) return true;

//         for(int neighbor : adj.getOrDefault(currNode,new ArrayList<>())){
//             if(!visited.contains(neighbor) && dfs(neighbor,destination)){
//                 return true;
//             }
//         }

//         return false;

//     }
// }

class Solution {
    HashMap<Integer,List<Integer>> adj = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // building graph from edges 
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            List<Integer> nodes = adj.getOrDefault(u,new ArrayList<>());
            nodes.add(v);
            adj.put(u,nodes);
            
            nodes = adj.getOrDefault(v,new ArrayList<>());
            nodes.add(u);
            adj.put(v,nodes);
        }

        return dfs(source, destination);
    }

    public boolean dfs(int curr, int destination) {
        visited.add(curr);
        if(curr == destination) return true;

        for(Integer nbr : adj.getOrDefault(curr,new ArrayList<>())){
            if(!visited.contains(nbr) && dfs(nbr,destination)) {
                return true;
            }
        }

        return false;
    }

        
    }


