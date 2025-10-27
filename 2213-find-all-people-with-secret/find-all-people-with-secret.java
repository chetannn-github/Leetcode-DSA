class Solution {
    HashMap<Integer,HashMap<Integer,List<Integer>>> timeGraph;
    HashSet<Integer> peopleKnows,currDFS;
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings,(a,b)->(a[2] - b[2]));
        peopleKnows = new HashSet<>();
        timeGraph = new HashMap<>();

        for(int[] meeting : meetings) {
            int u = meeting[0], v = meeting[1], time = meeting[2];
            HashMap<Integer,List<Integer>> graph  = timeGraph.getOrDefault(time,new HashMap<>());
            List<Integer> adj = graph.getOrDefault(u,new ArrayList<>());
            adj.add(v);
            graph.put(u,adj);

            adj = graph.getOrDefault(v,new ArrayList<>());
            adj.add(u);
            graph.put(v,adj);

            timeGraph.put(time,graph);
        }

        peopleKnows.add(firstPerson);
        peopleKnows.add(0);

        HashSet<Integer> timePassed = new HashSet<>();
        for(int[] meeting : meetings) {
            int time = meeting[2];
            if(timePassed.contains(time)) continue;

            timePassed.add(time);
            HashMap<Integer,List<Integer>> graph = timeGraph.get(time);
            HashSet<Integer> visited = new HashSet<>();

            for(int key : graph.keySet()) {
                if(!visited.contains(key)) {
                    currDFS = new HashSet<>();
                    if(dfs(key,graph, visited)) {
                        peopleKnows.addAll(currDFS);
                    }
                }
            }
            
        }


        return setToList(peopleKnows);
    }

    private List<Integer> setToList(HashSet<Integer> set) {
        List<Integer> list = new ArrayList<>();
        for(int key : set) {
            list.add(key);
        }
        return list;
    }

    private boolean dfs(int curr,HashMap<Integer,List<Integer>> graph,HashSet<Integer> visited) {
        visited.add(curr);
        boolean result = peopleKnows.contains(curr);
        currDFS.add(curr);

        for(int nbr : graph.get(curr)) {
            if(!visited.contains(nbr)) {
                if(dfs(nbr,graph,visited)) result = true;
            }
        }

        return result;
    }
}