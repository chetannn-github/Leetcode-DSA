class Solution {
    int[] ans;
    HashSet<Integer> visited;
    List<Integer>[] adj;
    String labels;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.ans = new int[n];
        constructGraph(n,edges);

        this.visited = new HashSet<>();
        this.labels = labels;

        dfs(0);
        return ans;
    }

    public int[] dfs(int source){
        visited.add(source);
        int[] freq = new int[26];

        for(int nbr : adj[source]){
            if(!visited.contains(nbr)){
                int[] ans = dfs(nbr);
                for(int i=0; i<26; i++){
                    freq[i] += ans[i];
                }
            }
        }

        ans[source] = ++freq[labels.charAt(source) - 'a'];
        return freq;
        
    }

    public void constructGraph(int n, int[][] edges) {
        this.adj = new List[n];

        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
    }
}