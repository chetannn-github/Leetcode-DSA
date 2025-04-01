class Solution {
    HashSet<Integer> visited;
    HashMap<Integer,List<Integer>> hm;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        visited = new HashSet<>();
        hm = new HashMap<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j]==1){
                    List<Integer> nodes = hm.getOrDefault(i,new ArrayList<>());
                    nodes.add(j);
                    hm.put(i,nodes);
                }
            }
        }
        int count = 0;
        for(int i=0; i<n; i++){
            if(!visited.contains(i)){
                dfs(i);
                count++;

            }
        }

        return count;
    }


    public void dfs(int currNode){
        visited.add(currNode);
        for(int node : hm.getOrDefault(currNode,new ArrayList<>())){
            if(!visited.contains(node)){
                dfs(node);
            }
            
        }
    }
}