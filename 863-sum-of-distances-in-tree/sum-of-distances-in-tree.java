class Solution {
    int[] childrenCount, result;
    List<Integer>[] adj;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // assume a root let say root is 0
        adj = constructGraph(n, edges); 
        childrenCount = new int[n]; 
        result = new int[n];
        countChildrenAndCalForRoot(0, new HashSet<>(), 0);
        
        calculateForAllRoots(0, new HashSet<>(), n, -1);
    
        return result;

    }

    public List<Integer>[] constructGraph(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];

        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        return adj;
    }

    public int countChildrenAndCalForRoot(int curr, HashSet<Integer> visited, int level) {
        visited.add(curr);
        int children = 0;

        for(int nbr : adj[curr]) {
            if(!visited.contains(nbr)) {
                children += 1 + countChildrenAndCalForRoot(nbr,visited, level+1);
            }
        }
        childrenCount[curr] = children;
        result[0] += level;
        return children;

    }

    public void calculateForAllRoots(int curr, HashSet<Integer> visited, int n, int parent) {
        visited.add(curr);

        if (parent != -1) {
            result[curr] = result[parent] + n - 2 * (childrenCount[curr] + 1);
        }

        for(int nbr : adj[curr]) {
            if(!visited.contains(nbr)) {
                calculateForAllRoots(nbr,visited,n, curr);
            }
        }

    }

}