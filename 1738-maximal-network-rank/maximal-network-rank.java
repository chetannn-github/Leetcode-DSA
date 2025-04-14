class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] road : roads){
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        int max = 0;

        for(int i=0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int count = 0;
                for(int nb : adj.get(i)) count++;
                for(int nb : adj.get(j)) {
                    if(nb != i) count++;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}