class Solution {
    List<Integer>[] graph;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        graph = buildGraph(edges); 
        HashSet<Integer> visited = new HashSet<>();
        int longestCycle = 0;

        for(int i=0; i<n; i++) {
            if(!visited.contains(i)) {
                longestCycle = Math.max(longestCycle, findLongestCycle(i,visited,new HashMap<>(),0, 0));
            }
        }

        return longestCycle == 0 ? -1 : longestCycle;
    }

    private List<Integer>[] buildGraph(int[] edges) {
        int n = edges.length;
        List<Integer>[] graph = new List[n];

        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int v = edges[i], u = i;
            if(v == -1) continue;
            graph[u].add(v);
        }
        return graph;
    }


     private int findLongestCycle( int curr,HashSet<Integer> visited,HashMap<Integer,Integer> currRecursion, int maxCycle,int depth) {
        visited.add(curr);
        currRecursion.put(curr, depth);

        for(int nbr : graph[curr]) {
            if(currRecursion.containsKey(nbr) ) {
                int cycleLength = depth - currRecursion.get(nbr) + 1;
                maxCycle = Math.max(maxCycle, cycleLength);
            }else if(!visited.contains(nbr)) {
                maxCycle = Math.max(maxCycle, findLongestCycle(nbr, visited,currRecursion, maxCycle, depth+1));
            }
        }

        currRecursion.remove(curr);

        return maxCycle;
    }
}