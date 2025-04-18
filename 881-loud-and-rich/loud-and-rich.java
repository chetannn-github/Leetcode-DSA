class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> parents = new ArrayList<>();

        int n = quiet.length;
        int[] indegree = new int[n];
        
        for(int i=0;i<n; i++) {
            adj.add(new ArrayList<>()); 
            parents.add(new ArrayList<>());
        }

        for(int[] edge : richer){
            adj.get(edge[0]).add(edge[1]);
            parents.get(edge[1]).add(edge[0]);

            indegree[edge[1]]++;
        }
        int[] ans = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                queue.add(i);
                ans[i] = i;
            }
        }        

        while(!queue.isEmpty()){
            int curr = queue.remove();
                
            for(int nbr : adj.get(curr)){
                if(--indegree[nbr] == 0){
                    queue.add(nbr);
                    int minLevel = quiet[nbr];
                    int minLevelPerson = nbr;

                    for(int parent : parents.get(nbr)){
                        if(quiet[ans[parent]] < minLevel){
                            minLevel = quiet[ans[parent]];
                            minLevelPerson = ans[parent];
                        }
                    }
                    ans[nbr] = minLevelPerson;
                }
        
            } 
        }
        return ans;
    }
}