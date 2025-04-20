class Solution {
    HashSet<Integer> visited;
    List<List<Integer>> adj;
    int[] degree; 
    int countNodesCovered;
    public int countCompleteComponents(int n, int[][] edges) {
        this.visited = new HashSet<>();
        this.adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        degree = new int[n];        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        int count = 0;
        for(int i=0; i<n; i++){
            if(!visited.contains(i)){
                countNodesCovered = 0;
                if(dfs(i,degree[i]) && countNodesCovered == degree[i]+1){
                    count++;
                        
                }      
            }
        }

        return count;
    }

    public boolean dfs(int curr,int currDegree){
        visited.add(curr);
        boolean ans = true;
        countNodesCovered++;

        for(int nbr : adj.get(curr)){
            if(!visited.contains(nbr)){
                ans = ans && dfs(nbr,currDegree);
            }
            if(degree[nbr] != currDegree){
                ans = false;
            }
        }

        return ans;
    }




    
}