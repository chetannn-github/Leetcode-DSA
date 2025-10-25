class Solution {
    public int numBusesToDestination(int[][] routes, int src, int target) {
        if(src == target) return 0;

        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        int n = routes.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<routes[i].length; j++) {
                List<Integer> route = hm.getOrDefault(routes[i][j], new ArrayList<>());
                route.add(i);
                hm.put(routes[i][j], route);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        for(int route : hm.getOrDefault(src, new ArrayList<>())){
            queue.add(route);
            visited.add(route);
        }

        int busTaken = 1;
        while(!queue.isEmpty()) {
            int currSize = queue.size();

            while(currSize-->0) {
                int currRoute = queue.remove();
                for(int dest : routes[currRoute]) {
                    if(dest == target) return busTaken;
                    for(int route : hm.get(dest)) {
                        if(visited.contains(route)) continue;

                        visited.add(route);
                        queue.add(route);
                    }
                }
                
            }

            busTaken++;
        }
        return -1;
    }
}