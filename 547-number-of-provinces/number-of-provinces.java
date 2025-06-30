class Solution {
    HashSet<Integer> visited;
    HashMap<Integer,List<Integer>> adj;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        visited = new HashSet<>();
        adj = new HashMap<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j]==1){
                    List<Integer> nodes = adj.getOrDefault(i,new ArrayList<>());
                    nodes.add(j);
                    adj.put(i,nodes);

                    // no need kukii dfs marjaaegaa ek relation hua tbhii bhii
                    // nodes = adj.getOrDefault(j , new ArrayList<>());
                    // nodes.add(i);
                    // adj.put(j , nodes);
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
        for(int node : adj.getOrDefault(currNode,new ArrayList<>())){
            if(!visited.contains(node)){
                dfs(node);
            }
            
        }
    }
}