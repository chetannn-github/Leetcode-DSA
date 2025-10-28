class Solution {
    public int[] restoreArray(int[][] adjPairs) {
        int n = adjPairs.length + 1;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer,Integer> degree = new HashMap<>();
        int oneDegreeNode = -1;

        for(int[] edge : adjPairs) {
            int u = edge[0], v = edge[1];
            List<Integer> adj = graph.getOrDefault(u, new ArrayList<>());
            adj.add(v);
            graph.put(u,adj);

            adj = graph.getOrDefault(v, new ArrayList<>());
            adj.add(u);
            graph.put(v,adj);

            degree.put(u, degree.getOrDefault(u,0)+1);
            degree.put(v, degree.getOrDefault(v,0)+1);
        }

        for(int key : degree.keySet()) {
            if(degree.get(key) == 1) {
                oneDegreeNode = key;
                break;
            }
        }


        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        queue.add(oneDegreeNode);
        visited.add(oneDegreeNode);
        int[] result = new int[n];
        int idx = 0;

        while(!queue.isEmpty()) {
            int curr = queue.remove();
            result[idx++] = curr;

            for(int nbr : graph.get(curr)) {
                if(!visited.contains(nbr)) {
                    queue.add(nbr);
                    visited.add(nbr);
                }
            }

        }

        return result;
        
    }
}