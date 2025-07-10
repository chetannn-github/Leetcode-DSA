class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        HashMap<Integer,List<Integer>> redAdj = new HashMap<>();
        HashMap<Integer,List<Integer>> blueAdj = new HashMap<>();

        for(int[] edge : redEdges) {
            int u = edge[0];
            int v = edge[1];
            List<Integer> nbrs = redAdj.getOrDefault(u,new ArrayList<>());
            nbrs.add(v);
            redAdj.put(u,nbrs);
        }

        for(int[] edge : blueEdges) {
            int u = edge[0];
            int v = edge[1];
            List<Integer> nbrs = blueAdj.getOrDefault(u,new ArrayList<>());
            nbrs.add(v);
            blueAdj.put(u,nbrs);
        }

        

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
                    for(int nbr : redAdj.getOrDefault(currNode, new ArrayList<>())) {
                        if(!redVisited.contains(nbr)) {
                            redVisited.add(nbr);
                            queue.add(new Pair(nbr,1));
                        }
                    }
                    for(int nbr : blueAdj.getOrDefault(currNode, new ArrayList<>())) {
                        if(!blueVisited.contains(nbr)) {
                            blueVisited.add(nbr);
                            queue.add(new Pair(nbr,2));
                        }
                    }
                }else if(prevColor == 1) {
                    for(int nbr : blueAdj.getOrDefault(currNode, new ArrayList<>())) {
                        if(!blueVisited.contains(nbr)) {
                            blueVisited.add(nbr);
                            queue.add(new Pair(nbr,2));
                        }
                    }
                }else {
                    for(int nbr : redAdj.getOrDefault(currNode, new ArrayList<>())) {

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


}

class Pair {
    int node, prevColor;
    Pair(int node, int prevColor) {
        this.node = node;
        this.prevColor = prevColor;
    }
}