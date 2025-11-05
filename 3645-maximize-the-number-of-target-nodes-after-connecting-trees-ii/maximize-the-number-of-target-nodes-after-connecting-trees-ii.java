class Solution { 
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        // assume a root let say root is 0
        int n = edges1.length+1, m = edges2.length+1;
        List<Integer>[] graph1 = constructGraph(n, edges1);
        List<Integer>[] graph2 = constructGraph(m, edges2);
        
        
        int[] result1 = calcForRoot(graph1,0, new HashSet<>(), 0, true,new int[n]);         
        calculateForAllNodes(graph1,0, new HashSet<>(), n, -1, result1);

        int[] result2 = calcForRoot(graph2,0, new HashSet<>(), 0, false,new int[m]);         
        calculateForAllNodes(graph2, 0, new HashSet<>(), m, -1, result2);

        int maxOfRes2 = findMaxInArray(result2);

        for(int i=0; i<n; i++) result1[i] += maxOfRes2;
        
    
        return result1;

    }

    public List<Integer>[] constructGraph(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];

        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        return graph;
    }

    public int[] calcForRoot(List<Integer>[] graph, int curr, HashSet<Integer> visited, int level, boolean evenLevel, int[] result) {
        visited.add(curr);
        
        for(int nbr : graph[curr]) {
            if(!visited.contains(nbr)) {
                calcForRoot(graph,nbr, visited, level+1, evenLevel, result);
            }
        }
        result[0] += evenLevel ? (1 - level % 2) : (level % 2) ;
        return result;
    }

    public void calculateForAllNodes(List<Integer>[] graph,int curr, HashSet<Integer> visited, int n, int parent, int[] result) {
        visited.add(curr);

        if (parent != -1) {
            result[curr] = n - result[parent];
        }

        for(int nbr : graph[curr]) {
            if(!visited.contains(nbr)) {
                calculateForAllNodes(graph,nbr,visited,n, curr, result);
            }
        }
    }

    private int findMaxInArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num : nums) max = Math.max(num,max);
        return max;
    }
}