class Solution {
    // all i need to find cycle in directed graph
    HashMap<Integer,List<Integer>> adj;
    HashSet<Integer> visited;
    HashSet<Integer> currRecursion;
    
    public boolean canFinish(int numCourses, int[][] pre) {
        adj = new HashMap<>();
        visited = new HashSet<>();
        currRecursion = new HashSet<>();

        for(int[] relation : pre){
            List<Integer> nodes = adj.getOrDefault(relation[1], new ArrayList<>());
            nodes.add(relation[0]);
            adj.put(relation[1],nodes);
        }


        for(int node : adj.keySet()){
            if(!visited.contains(node) && !checkCycle(node)){
                return false;
            }
        }
        return true;
        
    }


    public boolean checkCycle(int currNode){
        visited.add(currNode);
        currRecursion.add(currNode);

        for(int neighbour : adj.getOrDefault(currNode, new ArrayList<>())){
            if(! visited.contains(neighbour) && !checkCycle(neighbour)){
                return false;
            }else if(currRecursion.contains(neighbour)){
                return false;
            }

        }

        currRecursion.remove(currNode);

        return true;
    }
}