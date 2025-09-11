class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length, m = edges2.length;
        int[] result = new int[n+1];
        
        if(k == 0) {
            Arrays.fill(result,1);
            return result;
        }
        List<Integer>[] tree1 = constructTree(n+1,edges1);
        List<Integer>[] tree2 = constructTree(m+1,edges2);
        

        int maxNodesCoveredInTree2= 0;
        for(int i=0; i<m+1; i++) {
            maxNodesCoveredInTree2 = Math.max(maxNodesCoveredInTree2, bfs(i,k-1, tree2));
        }
        for(int i=0; i<n+1; i++) {
            result[i] = bfs(i, k, tree1) + maxNodesCoveredInTree2;
        }

        return result;
    }


    public int bfs(int start, int maxDepth,List<Integer>[]  tree ) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        

        queue.add(start);
        visited.add(start);

        int currDepth = 0;

        while(!queue.isEmpty() && currDepth < maxDepth) {
            int currSize = queue.size();

            while(currSize-->0) {
                int curr = queue.remove();

                for(int nbr : tree[curr]) {
                    if(visited.contains(nbr)) continue;

                    queue.add(nbr);
                    visited.add(nbr);
                }
            }

            currDepth++;
        }
        


        return visited.size();
    }


    private List<Integer>[] constructTree(int size, int[][] edges) {
        List<Integer>[] tree = new List[size];
       
        for(int i=0; i<size; i++) tree[i] = new ArrayList<>();

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            tree[u].add(v);
            tree[v].add(u);
        }
        return tree;
        
    }
}
