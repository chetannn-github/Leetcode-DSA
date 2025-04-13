class Solution {
    int[] ans;
    HashSet<Integer> visited;
    List<List<Integer>> adj;
    String labels;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.ans = new int[n];
        this.adj = new ArrayList<>();
        this.visited = new HashSet<>();
        this.labels = labels;

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        dfs(0);
        return ans;
    }

    public int[] dfs(int source){
        visited.add(source);
        int[] freq = new int[26];

        for(int nbr : adj.get(source)){
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
}