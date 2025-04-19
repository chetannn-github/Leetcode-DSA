class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] cost = new int[1001];
        for(int[] item : items1){
            cost[item[0]] += item[1];
        }

        for(int[] item : items2){
            cost[item[0]] += item[1];
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<1001;i++){
            if(cost[i] > 0){
                ans.add(Arrays.asList(i,cost[i]));
            }
        }

        return ans;
    }
}