// class Solution {
//     HashMap<Integer,Integer> visited;

//     public boolean isBipartite(int[][] graph) {
//         visited = new HashMap<>();

//         for(int i=0; i<graph.length; i++){
//             if(visited.getOrDefault(i,-1) == -1 && !dfs(i,0,graph)){
//                 return false;
//             }
//         }
//         return true;
//     }

//     public boolean dfs(int currNode, int currColor, int[][] graph){
//         visited.put(currNode,currColor);

//         for(int neighbour : graph[currNode] ){

//             if(!visited.containsKey(neighbour) && !(dfs(neighbour , 1 - currColor , graph)) ){
//                 return false;
//             }else if(visited.get(neighbour) == currColor){
//                 return false;
//             }
//         }
//         return true;
//     }
// }

class Solution {
    

    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        Arrays.fill(color,-1);
    
        for(int i=0; i<graph.length; i++){
            if(color[i] == -1){
                color[i] = 0;
                if(!bfs(graph, color, i)) return false;
            }
        }

        return true;

        
    }

    public boolean bfs(int[][] graph, int[] color, int currNode){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currNode);

        while(!queue.isEmpty()){
            int curr = queue.remove();

            for(int neighbor : graph[curr]){
                if(color[neighbor] == -1){
                    color[neighbor] = 1 - color[curr];
                    queue.add(neighbor);
                }else if(color[neighbor] == color[curr]){
                    return false;
                }
            }
        }
        return true;
    }

   
}