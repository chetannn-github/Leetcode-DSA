// dsu nhii lagegaa broo kukii it is not like a b ko kregaa toh b a ko kregaa
class Solution {
    List<Integer>[] adj;
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        constructGraph(bombs, n);

        int maxVisited = 1;
        HashSet<Integer> visited = new HashSet<>();
        for(int i=0; i<n;i++){
            dfs(i,visited);
            maxVisited = Math.max(visited.size(), maxVisited);
            visited.clear();
        }
        return maxVisited;
    }


    public void dfs(int curr, HashSet<Integer> visited){
        visited.add(curr);

        for(int nbr : adj[curr]){
            if(!visited.contains(nbr)){
                dfs(nbr,visited);
            }
        }
    }

    public void constructGraph(int[][] bombs, int n) {
        adj = new List[n];
        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                long dSquare = (long) Math.pow(bombs[i][0] - bombs[j][0],2) 
                + (long) Math.pow(bombs[i][1] - bombs[j][1],2); 
                
                int r1 = bombs[i][2];
                int r2 = bombs[j][2];
                if((long) r1*r1 >= dSquare){
                    adj[i].add(j);
                }
                if((long) r2*r2 >= dSquare){
                    adj[j].add(i);
                }
            }
        }
    } 
}