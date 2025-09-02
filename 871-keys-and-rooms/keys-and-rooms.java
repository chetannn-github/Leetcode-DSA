class Solution {
    HashSet<Integer> visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new HashSet<>();
        dfs(0,rooms);
        return visited.size() == rooms.size();
    }

    public void dfs(int currNode, List<List<Integer>> rooms){
        visited.add(currNode);
        

        for(int neighbour : rooms.get(currNode)){
            if(!visited.contains(neighbour)){
                dfs(neighbour, rooms);
            }
        }

        return;
    }
}