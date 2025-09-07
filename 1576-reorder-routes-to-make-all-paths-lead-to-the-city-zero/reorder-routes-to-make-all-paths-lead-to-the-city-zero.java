class Solution {
    List<List<List<Integer>>> adj;
    int count;
    
    public int minReorder(int n, int[][] edges) {
        adj = new ArrayList<>();
        count = 0;
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(Arrays.asList(v,1));
            adj.get(v).add(Arrays.asList(u,-1));

        }

        dfs(0,-1);// kuki sirf 2 roads hii ho skte hh ek node se toh we dont need visited set
        return count;
    }

    public void dfs(int curr,int parent){
        
        for(List<Integer> nbr : adj.get(curr)){
            int nb = nbr.get(0);
            if(nb != parent){
                boolean real = nbr.get(1) == 1 ;
                if(real) count++;
                dfs(nb,curr);
            }
        }
    }
}