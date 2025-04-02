class Solution {
    HashMap<Integer,List<Integer>> adj;
    HashSet<Integer> visited;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        adj = new HashMap<>();
        visited = new HashSet<>();

        for(int[] edge : edges){
            List<Integer> nodes = adj.getOrDefault(edge[0] , new ArrayList<>());
            nodes.add(edge[1]);
            adj.put(edge[0] , nodes);
            
            nodes = adj.getOrDefault(edge[1] , new ArrayList<>());
            nodes.add(edge[0]);
            adj.put(edge[1] , nodes);
        }

        return dfs(source, destination);
    }


    public boolean dfs(int currNode, int destination){
        visited.add(currNode);

        if(currNode == destination) return true;

        for(int neighbor : adj.getOrDefault(currNode,new ArrayList<>())){
            if(! visited.contains(neighbor) && dfs(neighbor,destination)){
                return true;
            }
        }

        return false;

    }
}