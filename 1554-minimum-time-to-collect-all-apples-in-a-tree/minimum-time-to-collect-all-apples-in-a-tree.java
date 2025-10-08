// child apne parent ko signal degaa if neg nhii hain bro mere lineage me 
// aur time > 0 then hain broo mere paas phrr tum +2 krogee kukii you need to go there

class Solution {
    HashSet<Integer> visited;
    List<Integer>[] graph;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        constructGraph(n,edges);
        visited = new HashSet<>();
        int res = dfs(0,hasApple);
        return res < 0 ? 0 : res ;
    }


    public int dfs(int curr,List<Boolean> hasApple){
        visited.add(curr);
        int time = 0;

        for(Integer nbr : graph[curr]){
            if(!visited.contains(nbr)){
                int res = dfs(nbr,hasApple);
                time += res < 0 ?  0 : res + 2;
            }
        }

        if(time == 0 && !hasApple.get(curr)) {
            return -1;
        }
        return time;
    }

    public void constructGraph(int n, int[][] edges) {
        graph = new List[n];
        visited = new HashSet<>();

        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            List<Integer> nbr = graph[u];
            nbr.add(v);
            graph[u] = nbr;

            nbr = graph[v];
            nbr.add(u);
            graph[v] = nbr;

        }
    }
}