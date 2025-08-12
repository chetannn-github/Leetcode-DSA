class Solution {
    int diameterEnd = -1, maxDepth = 0;
    List<List<Integer>> adj;List<Integer> result;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        result = new ArrayList<>();
        if(n==1) {
            result.add(0);
            return result;
        }
        adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(0, new HashSet<>(), 0, false);
        int oneEnd = diameterEnd;
        maxDepth = 0;
        diameterEnd = -1;
        dfs(oneEnd,new HashSet<>(), 0, false);
        int secondEnd = diameterEnd;

        
        
        dfs(oneEnd, new HashSet<>(), 0, true);
        // System.out.println(oneEnd+"->"+secondEnd+  "->"+maxDepth);
        return result;
    }


    public boolean dfs(int currNode, HashSet<Integer> visited, int currDepth, boolean isAddedToList) {
        visited.add(currNode);
    
        if(currDepth > maxDepth) {
            maxDepth = currDepth;
            diameterEnd = currNode;
        }

        boolean ans = currNode == diameterEnd;
        for(int nbr : adj.get(currNode)) {
            if(!visited.contains(nbr)) {
                if(dfs(nbr,visited, currDepth + 1,isAddedToList)) {
                    ans = true;
                }
            }
        }
        
        
        if(ans && isAddedToList) {
            if((maxDepth & 1) == 1) {
                if(currDepth == maxDepth/2 || currDepth == maxDepth / 2 + 1) {
                    result.add(currNode);
                }
            }else {
                if(currDepth == maxDepth /2 ) result.add(currNode);
            }
        }

        return ans;
    }
}