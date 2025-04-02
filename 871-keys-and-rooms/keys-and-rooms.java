class Solution {
    HashSet<Integer> visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new HashSet<>();

        return dfs(0, rooms) == rooms.size();
    }

    public int dfs(int currNode, List<List<Integer>> rooms){
        visited.add(currNode);
        int count = 1;

        for(int neighbour : rooms.get(currNode)){
            if(!visited.contains(neighbour)){
                count += dfs(neighbour, rooms);
            }
        }

        return count;
    }
}