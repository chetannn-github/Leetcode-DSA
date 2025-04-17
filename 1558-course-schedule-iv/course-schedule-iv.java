class Solution {
    List<List<Integer>> adj;
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] queries) {
        adj = new ArrayList<>();

        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] edge : pre){
            adj.get(edge[0]).add(edge[1]);
        }

        List<Boolean> results = new ArrayList<>();
        
        for(int[] q : queries){
            results.add(bfs(q[0], q[1]));
        }

        return results;
    }

    public boolean bfs(int s, int e){
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);

        while(!queue.isEmpty()){
            int curr = queue.remove();

            if(curr == e) return true;

            for(int nbr : adj.get(curr)){
                if(!visited.contains(nbr)){
                    queue.add(nbr);
                    visited.add(nbr);
                }
            }
            
        }

        return false;
    }
}