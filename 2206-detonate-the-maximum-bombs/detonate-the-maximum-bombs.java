class Solution {
    List<List<Integer>> adj;
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j) continue;
                long dSquare =(long) Math.pow( bombs[i][0] - bombs[j][0] , 2) +(long) Math.pow(bombs[i][1] - bombs[j][1],2); 
                
                int r1 = bombs[i][2];
                int r2 = bombs[j][2];
                if((long) r1*r1 >= dSquare){
                    adj.get(i).add(j);
                }

                
            }
        }
        // System.out.println(adj.toString());
        int max = 1;
        HashSet<Integer> visited = new HashSet<>();
        for(int i=0; i<n;i++){
            
            dfs(i,visited);
            max = Math.max(visited.size(), max);
            visited.clear();
        }
        return max;
    }


    public void dfs(int curr, HashSet<Integer> visited){
        visited.add(curr);

        for(int nbr : adj.get(curr)){
            if(!visited.contains(nbr)){
                dfs(nbr,visited);
            }
        }


    }
}