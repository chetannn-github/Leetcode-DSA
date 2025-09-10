class Solution {
    int n;HashSet<Integer> visited;
    public int removeStones(int[][] stones) {
        int groups = 0;
        n = stones.length;
        visited = new HashSet<>();

        for(int i=0; i<n; i++){
            if(!visited.contains(i)){
                dfs(stones,i);
                groups++;
            }
        }

        return n - groups;
    }

    public void dfs(int[][] stones,int curr){
        visited.add(curr);

        for(int i=0; i<n; i++){
            if(!visited.contains(i) && 
                (stones[curr][0] == stones[i][0]  || stones[curr][1] == stones[i][1] )
            ){
                dfs(stones,i);
            }
        }
    }
}