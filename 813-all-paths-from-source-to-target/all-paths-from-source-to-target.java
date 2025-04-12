class Solution {
    List<List<Integer>> ans ;
    HashSet<Integer> visited;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        visited = new HashSet<>();

        dfs(graph,0,new ArrayList<>());

        return ans;
    }

    public void dfs(int[][] graph,int source,List<Integer> temp){
        temp.add(source);
        visited.add(source);


        if(source == graph.length-1){
            ans.add(new ArrayList<>(temp));
        }

        for(int i=0; i<graph[source].length; i++){
            if(!visited.contains(graph[source][i])){
                dfs(graph,graph[source][i], temp);
            }
        }

        visited.remove(source);
        temp.remove(temp.size()-1);

    }
}