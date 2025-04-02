class Solution {
    // all i need to find topological sort for this direction graph
    HashMap<Integer,List<Integer>> adj;
    HashSet<Integer> visited;
    HashSet<Integer> currRecursion;
    Stack<Integer> st;

    public int[] findOrder(int numCourses, int[][] pre){
        adj = new HashMap<>();
        visited = new HashSet<>();
        currRecursion = new HashSet<>();
        st = new Stack<>();

        for(int i=0; i<numCourses; i++){
            adj.put(i,new ArrayList<>());
        }

        for(int[] relation : pre){
            List<Integer> nodes = adj.getOrDefault(relation[1], new ArrayList<>());
            nodes.add(relation[0]);
            adj.put(relation[1],nodes);
        }

        
        for(int node : adj.keySet()){
            if(!visited.contains(node) && !checkCycle(node)){
                return new int[]{};
            }
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while(!st.isEmpty()){
            ans[idx++] = st.pop();
        }

        return ans;
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
        st.push(currNode);
        currRecursion.remove(currNode);

        return true;
    }
}