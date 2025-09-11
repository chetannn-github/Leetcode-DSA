class Solution {
    List<Integer>[] adj; 
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        adj = new List[n];
        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();
        for(int i=0; i<n-1; i++){
            adj[i].add(i+1);
        }
        
        int[] result = new int[queries.length];
        int idx = 0;
        
        for(int[] q : queries){
            int u = q[0];
            int v = q[1];
            adj[u].add(v);
            result[idx++] = bfs(n-1);
        }

        return result;
    }

    public int bfs(int goal){
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        
        int count = 0;
        while(!queue.isEmpty()){
            int n = queue.size();

            while(n-->0){
                int curr = queue.remove();
                if(curr == goal) return count;

                for(int nbr : adj[curr]){
                    if(!visited.contains(nbr)){
                        queue.add(nbr);
                        visited.add(nbr);
                    }
                }
            }

            count++;
        }

        return count;
        
    }
}