class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] redAdj = constructGraph(n,redEdges);
        List<Integer>[] blueAdj = constructGraph(n,blueEdges);
        
        Queue<Pair> queue = new LinkedList<>();
        HashSet<Integer> redVisited = new HashSet<>();
        HashSet<Integer> blueVisited = new HashSet<>();
        queue.add(new Pair(0,-1));
        int[] result = new int[n];
        Arrays.fill(result, -1);
        int steps = 0;

        while(!queue.isEmpty()) {
            int currSize = queue.size();

            while(currSize-->0) {
                
                Pair curr = queue.remove();
                int currNode = curr.node;
                if(result[currNode] == -1 || result[currNode] > steps) result[currNode] = steps;
                int prevColor = curr.prevColor;

                if(prevColor == -1) {
                    for(int nbr : redAdj[currNode]) {
                        if(!redVisited.contains(nbr)) {
                            redVisited.add(nbr);
                            queue.add(new Pair(nbr,1));
                        }
                    }
                    for(int nbr : blueAdj[currNode]) {
                        if(!blueVisited.contains(nbr)) {
                            blueVisited.add(nbr);
                            queue.add(new Pair(nbr,2));
                        }
                    }
                }else if(prevColor == 1) {
                    for(int nbr : blueAdj[currNode]) {
                        if(!blueVisited.contains(nbr)) {
                            blueVisited.add(nbr);
                            queue.add(new Pair(nbr,2));
                        }
                    }
                }else {
                    for(int nbr : redAdj[currNode]) {

                        if(!redVisited.contains(nbr)) {
                            redVisited.add(nbr);
                            queue.add(new Pair(nbr,1));
                        }
                    }
                }
            }
            steps++;
        }
        return result;
    }


    private List<Integer>[] constructGraph(int n,int[][] edges) {
        List<Integer>[] graph = new List[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            List<Integer> nbrs = graph[u];
            nbrs.add(v);
            graph[u] = nbrs;
        }
        return graph;
    }


}

class Pair {
    int node, prevColor;
    Pair(int node, int prevColor) {
        this.node = node;
        this.prevColor = prevColor;
    }
}