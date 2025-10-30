class Solution {
    List<Integer>[] graph;
    int[] subTreeXOR,inTime,outTime;
    int n,timer;

    // assume it is 0 rooted tree
    public int minimumScore(int[] nums, int[][] edges) {
        this.n = nums.length;
        subTreeXOR = new int[n];
        inTime = new int[n];
        outTime = new int[n];
        timer = 0;

        buildGraph(edges);
        dfs(0, -1,nums);
        int result = Integer.MAX_VALUE;

        for(int u=1; u<n; u++) {
            for(int v=u+1; v<n; v++) {
                int xor1, xor2, xor3;

                if(isAncestor(u, v)) {
                    xor1 = subTreeXOR[v];
                    xor2 = subTreeXOR[u] ^ subTreeXOR[v];
                }else if(isAncestor(v, u)) {
                    xor1 = subTreeXOR[u];
                    xor2 = subTreeXOR[v] ^ subTreeXOR[u];
                }else{
                    xor1 = subTreeXOR[u];
                    xor2 = subTreeXOR[v];
                }
                xor3  = subTreeXOR[0] ^ xor1 ^ xor2;
                result = Math.min(result, getScore(xor1, xor2, xor3));
            }
        }

        return result;
    }

    private void dfs(int node, int parent,int[] nums) {
        subTreeXOR[node] = nums[node];
        inTime[node] = timer++;

        for(int nbr : graph[node]) {
            if(nbr != parent) {
                dfs(nbr, node, nums);
                subTreeXOR[node] ^= subTreeXOR[nbr];
            }
        }

        outTime[node] = timer++;
    }

    private boolean isAncestor(int u, int v) {
        return inTime[v] > inTime[u] && outTime[v] < outTime[u];
    }

    private int getScore(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        return max - min;
    }

    private void buildGraph(int[][] edges) {
        this.graph = new List[n];

        for(int i = 0; i < n; i++) graph[i] =  new ArrayList<>();
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }   
    }
}