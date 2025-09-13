class Solution {
    int diameterEnd = -1, maxDepth = 0;
    List<Integer>[] graph;List<Integer> result;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n==1) return new ArrayList<>(List.of(0));

        constructGraph(edges,n);result = new ArrayList<>();
        dfs(0, new HashSet<>(), 0, false);
        int A = diameterEnd;

        maxDepth = 0;
        dfs(A,new HashSet<>(), 0, false);
        int B = diameterEnd;

        
        
        dfs(A, new HashSet<>(), 0, true);
        // System.out.println(A+"->"+B+  "->"+maxDepth);
        return result;
    }


    public boolean dfs(int currNode, HashSet<Integer> visited, int currDepth, boolean isToAddInList) {
        visited.add(currNode);
    
        if(currDepth > maxDepth) {
            maxDepth = currDepth;
            diameterEnd = currNode;
        }

        // bhai jo path B tak le jaae whii add kr skta hain jb depth suitable aaye

        boolean isPathToEndOfDiameter = currNode == diameterEnd;
        for(int nbr : graph[currNode]) {
            if(!visited.contains(nbr)) {
                if(dfs(nbr,visited, currDepth + 1,isToAddInList)) {
                    isPathToEndOfDiameter = true;
                }
            }
        }
        
        
        if(isPathToEndOfDiameter && isToAddInList) {
            if((maxDepth & 1) == 1) {
                if(currDepth == maxDepth/2 || currDepth == maxDepth / 2 + 1) {
                    result.add(currNode);
                }
            }else {
                if(currDepth == maxDepth /2 ) result.add(currNode);
            }
        }

        return isPathToEndOfDiameter;
        
    }


    public void constructGraph(int[][] edges, int n) {
        graph = new List[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
    }
}