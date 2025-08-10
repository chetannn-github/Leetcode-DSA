class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        
        int n = edges1.length, m = edges2.length;
        int[] result = new int[n+1];
        
        if(k == 0) {
            Arrays.fill(result,1);
            return result;
        }
        List<List<Integer>> tree1 = new ArrayList<>();
        for(int i=0; i<n+1; i++) tree1.add(new ArrayList<>());
        
        List<List<Integer>> tree2 = new ArrayList<>();
        for(int i=0; i<m+1; i++) tree2.add(new ArrayList<>());

        for(int[] edge : edges1) {
            int u = edge[0], v = edge[1];
            tree1.get(u).add(v);
            tree1.get(v).add(u);
        }
        
        for(int[] edge : edges2) {
            int u = edge[0], v = edge[1];
            tree2.get(u).add(v);
            tree2.get(v).add(u);
        }

        int maxNodesCoveredInTree2= 0;
        for(int i=0; i<m+1; i++) {
            maxNodesCoveredInTree2 = Math.max(maxNodesCoveredInTree2, bfs(i,k-1, tree2));
        }
        for(int i=0; i<n+1; i++) {
            result[i] = bfs(i, k, tree1) + maxNodesCoveredInTree2;
        }

        return result;
    }


    public int bfs(int start, int maxDepth,List<List<Integer>> tree ) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        

        queue.add(start);
        visited.add(start);

        int currDepth = 0;

        while(!visited.isEmpty() && currDepth < maxDepth) {
            int currSize = queue.size();

            while(currSize-->0) {
                int curr = queue.remove();

                for(int nbr : tree.get(curr)) {
                    if(visited.contains(nbr)) continue;

                    queue.add(nbr);
                    visited.add(nbr);
                }
            }

            currDepth++;
        }
        


        return visited.size();
    }
}
