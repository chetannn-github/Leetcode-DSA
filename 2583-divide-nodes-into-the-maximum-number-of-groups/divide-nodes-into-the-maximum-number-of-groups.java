class Solution {
    List<Integer>[] graph;
    int n;
    public int magnificentSets(int n, int[][] edges) {
        this.n = n;
        buildGraph(edges);
        boolean[] visited = new boolean[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            List<Integer> comp = new ArrayList<>();
            dfs(i, visited, comp);

            int maxDepth = 0;
            for(int node : comp) {
                int depth = bfs(node);
                if (depth == -1) return -1;
                maxDepth = Math.max(maxDepth, depth);
            }
            result += maxDepth;
        }
        return result;
    }

    private void buildGraph(int[][] edges) {
        this.graph = new List[n];

        for(int i = 0; i < n; i++) graph[i] =  new ArrayList<>();
        for(int[] edge : edges) {
            int u = edge[0]-1, v = edge[1]-1;
            graph[u].add(v);
            graph[v].add(u);
        }   
    }


    private int bfs(int start) {
        Queue<Pair> queue = new LinkedList<>();
        int group[] = new int[n];
        int groupLabel = 0;
    
        Arrays.fill(group,-1);
        group[start] = groupLabel;
        queue.add(new Pair(start,-1));
        

        while(!queue.isEmpty()) {
            int currSize = queue.size();
            groupLabel++;

            while(currSize-->0) {
                Pair curr = queue.remove();
                int currNode = curr.node, parent = curr.parent;
                
                for(int nbr : graph[currNode]) {
                    if(nbr == parent) continue;

                    if(group[nbr] == -1) {
                        group[nbr] = groupLabel;
                        queue.add(new Pair(nbr,currNode)); 
                    }else if (Math.abs(group[nbr] - group[currNode]) != 1) return -1;
                }
            }
            
        }

        return groupLabel;
    }

    private void dfs(int u, boolean[] visited, List<Integer> comp) {
        visited[u] = true;
        comp.add(u);
        for(int v : graph[u]) {
            if(!visited[v]) dfs(v, visited, comp);
        }
    }
}

class Pair{
    int node,parent;
    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}