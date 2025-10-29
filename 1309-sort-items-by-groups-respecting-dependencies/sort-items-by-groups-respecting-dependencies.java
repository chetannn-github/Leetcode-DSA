class Solution {
        Map<Integer, List<Integer>> itemGraph,groupGraph;
        int[] itemIndegree,groupIndegree;
        public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for(int i=0; i<n; i++) {
            if(group[i] == -1) group[i] = m++;
        }
        
        buildItemAndGroupGraph(n,m,group,beforeItems);
        List<Integer> itemOrder  = topoSort(itemGraph, itemIndegree);
        List<Integer> groupOrder = topoSort(groupGraph, groupIndegree);
        

        Map<Integer, List<Integer>> groupToItems = new HashMap<>();
        for(Integer item : itemOrder) {
            int itemGroup = group[item];
            List<Integer> groupElements = groupToItems.getOrDefault(itemGroup, new ArrayList<>()); 
            groupElements.add(item);
            groupToItems.put(itemGroup, groupElements);
        }
        
        List<Integer> resultList = new ArrayList<>();
        for(int groupIndex : groupOrder) {
            resultList.addAll(groupToItems.getOrDefault(groupIndex, new ArrayList<>()));
        }
        
        return listToArray(resultList);
    }
    
    private List<Integer> topoSort(Map<Integer, List<Integer>> adj, int[] indegree) {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0;i<indegree.length;i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while(!que.isEmpty()) {
            Integer curr = que.remove();
            result.add(curr);
            
            for (Integer v : adj.get(curr)) {
                indegree[v]--;
                
                if(indegree[v] == 0){
                    que.add(v);
                }
            }
        }

        return result.size() == adj.size() ? result : new ArrayList<>();
    }

    private void buildItemAndGroupGraph(int n,int m, int[] group, List<List<Integer>> beforeItems) {
        itemGraph = new HashMap<>();
        groupGraph = new HashMap<>();
        itemIndegree = new int[n];
        groupIndegree = new int[m];

        for(int i=0; i<n; ++i) itemGraph.put(i, new ArrayList<>());
        for(int i=0; i<m; ++i) groupGraph.put(i, new ArrayList<>());
        
        for(int i=0; i<n; i++) {
            for(int prev : beforeItems.get(i)) {
                itemGraph.get(prev).add(i);
                itemIndegree[i]++;
                
                if(group[i] != group[prev]) {
                    int prevGroup = group[prev],currGroup = group[i];
                    groupGraph.get(prevGroup).add(currGroup);
                    groupIndegree[currGroup]++;
                }
                
            }
        }
    }

    private int[] listToArray(List<Integer> list) {
        int n = list.size();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = list.get(i);
        return arr;
    }
}