class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<HashSet<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new HashSet<>());

        for(int[] road : roads){
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        int max = 0;

        for(int i=0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int count = adj.get(i).size();
                if(adj.get(j).contains(i)) count--;
                count += adj.get(j).size();
                max = Math.max(count, max);
            }
        }
        return max;
    }
}