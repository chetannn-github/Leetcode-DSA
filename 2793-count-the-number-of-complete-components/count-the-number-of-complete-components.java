class Solution {
    // har node kii uske saare neiborss se direct batcheet honi chaiyee
    HashSet<Integer> visited;
    List<Integer>[] graph;
    int[] degree; 
    int nodesCovered;
    public int countCompleteComponents(int n, int[][] edges) {
        constructGraphAndCalculateDegree(edges,n);
        this.visited = new HashSet<>();
        
        
        int count = 0;
        for(int i=0; i<n; i++){
            if(!visited.contains(i)){
                nodesCovered = 0;
                if(dfs(i,degree[i]) && nodesCovered == degree[i]+1){
                    count++;     
                }      
            }
        }

        return count;
    }

    public boolean dfs(int curr,int parentDegree){
        visited.add(curr);
        boolean ans = true;
        nodesCovered++;

        for(int nbr : graph[curr]){
            if(!visited.contains(nbr)){
                ans = ans && dfs(nbr,parentDegree);
            }
            if(degree[nbr] != parentDegree){
                ans = false;
            }
        }

        return ans;
    }


    private void constructGraphAndCalculateDegree(int[][] edges,int n) {
        graph = new List[n];
        degree = new int[n];     
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        
          
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);

            degree[u]++;
            degree[v]++;
        }
    }




    
}
