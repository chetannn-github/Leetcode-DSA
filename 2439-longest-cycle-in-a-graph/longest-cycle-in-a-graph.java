class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        HashSet<Integer> visited = new HashSet<>();
        int maxCycleLength = -1;

        for(int i=0; i<n; i++) {
            if(!visited.contains(i)) {
                int cycleNode = findCycleNode(edges,i,visited,new HashSet<>());
                if(cycleNode != -1) {
                    int cycleLength = findCycleLength(edges,cycleNode,new HashSet<>());
                    maxCycleLength = Math.max(cycleLength + 1, maxCycleLength);
                }
            }
        }

        return maxCycleLength;
    }

    private int findCycleNode(int[] edges,int curr, HashSet<Integer> visited, HashSet<Integer> currRecursion) {
        visited.add(curr);
        currRecursion.add(curr);
        int cycleNode = -1;
        int nbr = edges[curr];

        if(nbr != -1) {
            if(!visited.contains(nbr)) {
                cycleNode = findCycleNode(edges,nbr, visited,currRecursion);
            }else if (currRecursion.contains(nbr)) {
                return nbr;
            }
        }

        currRecursion.remove(curr);
        return cycleNode;
        
    }

    public int findCycleLength(int[] edges,int curr, HashSet<Integer> visited) {
        visited.add(curr);
        
        int cycleLength = 0;
        int nbr = edges[curr];

        if(nbr != -1) {
            if(!visited.contains(nbr)) {
                cycleLength += 1 + findCycleLength(edges,nbr, visited);
            }
        }

        return cycleLength ;
    }
}