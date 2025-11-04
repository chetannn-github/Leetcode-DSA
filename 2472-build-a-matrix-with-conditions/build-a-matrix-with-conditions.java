class Solution {
    public int[][] buildMatrix(int k, int[][] rowCondns, int[][] colCondns) {
        List<Integer> rowTopo = topologicalSort(rowCondns,k);
        if(rowTopo == null) return new int[][]{};
        List<Integer> colTopo = topologicalSort(colCondns,k);
        if(colTopo == null) return new int[][]{};

        HashMap<Integer,Integer> colIdxMap = new HashMap<>();
        int[][] result = new int[k][k];

        for(int col=0; col<k; col++) {
            int num = colTopo.get(col);
            colIdxMap.put(num,col);
        }
        
        for(int row=0; row<k; row++) {
            int num = rowTopo.get(row);
            int col = colIdxMap.get(num);
            result[row][col] = num + 1;
        }

        return result;
    }


    public List<Integer> topologicalSort(int[][] edges, int n) {
        List<Integer>[] graph = new List[n];
        int[] indegree = new int[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] edge : edges) {
            int u = edge[0]-1, v = edge[1]-1;
            graph[u].add(v);
            indegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            int currSize = queue.size();
            while(currSize--> 0) {
                int curr = queue.remove();
                topo.add(curr);

                for(int nbr : graph[curr]) {
                    if(--indegree[nbr] == 0) {
                        queue.add(nbr);
                    }
                }
            }
        }


        return topo.size() == n ? topo : null;


    }
}