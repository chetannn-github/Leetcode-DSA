class Solution {
    List<Integer>[] graph;
    HashSet<Couple> coupleNodes;
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        graph = buildReverseGraph(favorite); 
        findCoupleNodes(favorite,n);

        HashSet<Integer> visited = new HashSet<>();
        int longestCycle = 0;

        for(int i=0; i<n; i++) {
            if(!visited.contains(i)) {
                longestCycle = Math.max(longestCycle, findLongestCycle(i,visited,new HashMap<>(),0, 0));
            }
        }
        
        int maxInvitions = longestCycle;
        int coupleChain = 0;
        for (Couple coupleNode : coupleNodes) {
            int a = coupleNode.one, b = coupleNode.two;

            coupleChain += 2 + longestChain(a, b) + longestChain(b, a);
        }

        return Math.max(coupleChain,maxInvitions);
    }

    private List<Integer>[] buildReverseGraph(int[] edges) {
        int n = edges.length;
        List<Integer>[] graph = new List[n];

        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int u = edges[i], v = i;
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


    private void findCoupleNodes(int[] edges, int n) {
        coupleNodes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (edges[edges[i]] == i && i < edges[i]) {
                coupleNodes.add(new Couple(i, edges[i]));
            }
        }
    }


    private int longestChain(int src, int block) {
        int best = 0;
        for (int nbr : graph[src]) {
            if (nbr == block) continue;
            best = Math.max(best, 1 + longestChain(nbr, block));
        }
        return best;
    }
}

class Couple {
    int one, two;
    Couple(int one, int two) {
        this.one = one;
        this.two = two;
    }

    @Override 
    public boolean equals(Object o) {
        Couple c = (Couple) o;
        return one == c.one && two == c.two;
    }

    @Override
    public int hashCode() {
        return Objects.hash(one,two);
    }
}