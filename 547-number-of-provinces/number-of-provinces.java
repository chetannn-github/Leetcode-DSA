class Solution {
    HashSet<Integer> visited;
    HashMap<Integer,List<Integer>> adj;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        visited = new HashSet<>();
        adj = new HashMap<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j]==1){
                    List<Integer> nodes = adj.getOrDefault(i,new ArrayList<>());
                    nodes.add(j);
                    adj.put(i,nodes);
                    // dusra relation aage aaegaa j --->> 1
                }
            }
        }
        int provinces = 0;
        for(int i=0; i<n; i++){
            if(!visited.contains(i)){
                dfs(i);
                provinces++;

            }
        }

        return provinces;
    }


    public void dfs(int currNode){
        visited.add(currNode);
        for(int node : adj.getOrDefault(currNode,new ArrayList<>())){
            if(!visited.contains(node)){
                dfs(node);
            }
            
        }
    }
}