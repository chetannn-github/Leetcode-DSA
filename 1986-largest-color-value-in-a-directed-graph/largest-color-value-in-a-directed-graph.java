class Solution {
    List<Integer>[] graph;
    int result = 1;
    HashMap<Integer,int[]> dp;
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        constructGraph(edges,n);
        List<Integer> topoSort = kahnAlgo(edges,n);
        if(topoSort.size() != n) return -1;

        dp = new HashMap<>();
       
        for(int node=0; node<n; node++) {
            if(!dp.containsKey(node)) { 
                dfs(node,colors);
            }
        }

        System.out.println(dp.toString());
        for(int i=0; i<n; i++) {
            for(int maxColor : dp.get(i)) {
                result = Math.max(maxColor, result);
            }
        }

        return result;
       
    }

    public List<Integer> kahnAlgo(int[][] edges, int n) {
        List<Integer> topoSort = new ArrayList<>();
        int[] indegree = new int[n];

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            int curr = queue.remove();
            topoSort.add(curr);

            for(int nbr : graph[curr]) {
                if(--indegree[nbr] == 0) queue.add(nbr);
            }
        }

        return topoSort;
    }

    private void constructGraph(int[][] edges, int n) {
        graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
        }
    }

    private int[] dfs(int curr, String colors) {
        if(dp.containsKey(curr)) { 
            return dp.get(curr);
        }

        
        int currColor = colors.charAt(curr) - 'a';
        int[] maxColors = new int[26];
        maxColors[currColor]++;

        for(int nbr : graph[curr]) {
            int[] myColors = dfs(nbr,colors);

            for(int i=0; i<26; i++) {
                maxColors[i] = Math.max(maxColors[i], myColors[i] + (i == currColor ? 1 : 0));
            }
        }

        dp.put(curr,maxColors);
        for (int val : maxColors) result = Math.max(result, val);

        return maxColors;
        
    } 
}