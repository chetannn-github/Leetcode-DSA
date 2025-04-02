class Solution {
    HashMap<Integer,Integer> visited;

    public boolean isBipartite(int[][] graph) {
        visited = new HashMap<>();

        for(int i=0; i<graph.length; i++){
            if(visited.getOrDefault(i,-1) == -1 && !dfs(i,0,graph)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int currNode, int currColor, int[][] graph){
        visited.put(currNode,currColor);

        for(int neighbour : graph[currNode] ){

            if(!visited.containsKey(neighbour) && !(dfs(neighbour , 1 - currColor , graph)) ){
                return false;
            }else if(visited.get(neighbour) == currColor){
                return false;
            }
        }
        return true;
    }
}