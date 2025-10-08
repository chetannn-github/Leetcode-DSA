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


