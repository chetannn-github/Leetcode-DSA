class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer,List<Integer>> adj = new HashMap<>();

        for(int[] edge : dislikes){
            List<Integer> node = adj.getOrDefault(edge[0],new ArrayList<>());
            node.add(edge[1]);
            adj.put(edge[0],node);

            node = adj.getOrDefault(edge[1],new ArrayList<>());
            node.add(edge[0]);
            adj.put(edge[1],node);
        }

        int[] color = new int[n+1];
        Arrays.fill(color,-1);
        
         for(int i=0; i<=n; i++){
            if(color[i] == -1){
                color[i] = 0;
                if(!bfs(adj, color, i)) return false;
            }
        }

        return true;
        
    }

    public boolean bfs(HashMap<Integer,List<Integer>> adj, int[] color, int currNode){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currNode);

        while(!queue.isEmpty()){
            int curr = queue.remove();

            for(int neighbor : adj.getOrDefault(curr,new ArrayList<>())){
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