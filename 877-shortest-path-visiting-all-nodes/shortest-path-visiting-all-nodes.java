class Solution {
    
    public int shortestPathLength(int[][] graph) {
       HashSet<String> visited = new HashSet<>();
       Queue<Pair> queue = new LinkedList<>();
       int n = graph.length;

       for(int i=0; i<n; i++) {
            int bitMask = (1 << i);
            String key = new String(i + "" + bitMask);
            visited.add(key);
            queue.add(new Pair(i, bitMask));
       }
        int pathLength = 0;
        while(!queue.isEmpty()) {
            int currSize = queue.size();
            while(currSize--> 0) {
                Pair curr = queue.remove();
                int currNode = curr.val;
                int currBitMask = curr.bitMask;

                if(currBitMask + 1 == (1 << n)) return pathLength;


                for(int nbr : graph[currNode]) {
                    int nextBitMask = currBitMask | (1 << nbr);
                    String nextKey = new String(nbr + "" + nextBitMask);

                    if(!visited.contains(nextKey)) {
                        visited.add(nextKey);
                        queue.add(new Pair(nbr, nextBitMask));
                    }
                }
            }
            pathLength++;
        }
        return pathLength;
    }
}

class Pair {
    int val, bitMask;
    Pair(int val, int bitMask) {
        this.val = val;
        this.bitMask = bitMask;
    }
}

