class Solution {
    HashMap<Integer,List<Integer>> adj;
    HashSet<Integer> visited;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        adj = new HashMap<>();
        visited = new HashSet<>();

        for(int[] edge : edges){
            List<Integer> ls = adj.getOrDefault(edge[0],new ArrayList<>());
            ls.add(edge[1]);
            adj.put(edge[0],ls);

            ls = adj.getOrDefault(edge[1],new ArrayList<>());
            ls.add(edge[0]);
            adj.put(edge[1],ls);
        }
        int ans = dfs(0,hasApple);

        return ans > 0 ? ans-2 : 0 ;
            
    }


    public int dfs(int curr,List<Boolean> hasApple){
        visited.add(curr);
        int time = 0;

        for(Integer nbr : adj.getOrDefault(curr,new ArrayList<>())){
            if(!visited.contains(nbr)){
                time += dfs(nbr,hasApple);
            }
        }

        if(hasApple.get(curr)){
            time +=2;
        }else if(time!=0){
            time +=2;
        }

        return time;
    }
}