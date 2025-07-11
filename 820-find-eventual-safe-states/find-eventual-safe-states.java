class Solution {
    
    boolean[] bl;
    HashSet<Integer> visited;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        bl = new boolean[graph.length];
        visited = new HashSet<>();


        for(int i=0; i<graph.length; i++){
            if(!visited.contains(i)){
                dfs(graph,i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<graph.length; i++){
            if(bl[i]){
                ans.add(i);
            }
        }

        return ans;
    }

    public boolean dfs(int[][] graph, int src){
        visited.add(src);
        boolean ans = true;
        for(int nbr : graph[src]){
            if(!visited.contains(nbr)){
                ans = ans && dfs(graph,nbr);
            }else {
                ans = ans && bl[nbr];
            }
        }

        return bl[src] = ans;
    }

}