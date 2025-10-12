class Solution {
    HashSet<Integer> visited;
    List<Integer>[] adj;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        constructGraph(isConnected, n);

        visited = new HashSet<>();
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
        for (int node : adj[currNode]) {
            if(!visited.contains(node)){
                dfs(node);
            }
            
        }
    }

    public void constructGraph(int[][] isConnected, int n) {
        adj = new List[n];

        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j]==1){
                    adj[i].add(j);
                    // dusra relation aage aaegaa j --->> 1
                }
            }
        }
    }
}