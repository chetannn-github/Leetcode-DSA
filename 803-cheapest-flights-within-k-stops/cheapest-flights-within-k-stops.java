class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<int[]> queue = new LinkedList<>();
        List<List<List<Integer>>> adj = new ArrayList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] flight : flights){
            List<Integer> ls = new ArrayList<>();
            ls.add(flight[1]);
            ls.add(flight[2]);
            adj.get(flight[0]).add(ls);
        }

        queue.add(new int[]{src,0});
        dist[src] = 0;
        int level = 0;

        while(!queue.isEmpty() && k >= level){
            int currSize = queue.size();

            while(currSize-->0){
                int[] curr = queue.remove();

                for(List<Integer> nbr : adj.get(curr[0])){
                    int nb = nbr.get(0);
                    int amt = nbr.get(1);
                    if(amt + curr[1] < dist[nb]){
                        dist[nb] = amt + curr[1];
                        queue.add(new int[]{nb,dist[nb]}); 
                    }  
                }
            }

            level++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }
}