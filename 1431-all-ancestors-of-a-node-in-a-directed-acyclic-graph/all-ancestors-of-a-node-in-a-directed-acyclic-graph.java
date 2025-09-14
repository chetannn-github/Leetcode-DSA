class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[] indegree = new int[n];
        List<Integer>[] graph = new List[n];
        constructGraphAndCalcIndegree(n, edges, indegree, graph);
        

        List<Set<Integer>> ancestors = new ArrayList<>();
        for(int i=0; i<n; i++) ancestors.add(new HashSet<>());
        

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int curr = queue.remove();

            for(int nbr : graph[curr]){
                ancestors.get(nbr).add(curr);
                for(int parentAncestor : ancestors.get(curr)){
                    ancestors.get(nbr).add(parentAncestor);
                }
                
                if(--indegree[nbr] == 0){
                    queue.add(nbr);   
                }
            }
        }

        
        return convertListOfSetToSortedList(ancestors,n);
    }


    private void constructGraphAndCalcIndegree(int n,int[][] edges,int[] indegree ,List<Integer>[] graph) {
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            indegree[v]++;
        }
    }


    private List<List<Integer>> convertListOfSetToSortedList(List<Set<Integer>> ancestors, int n){
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<n; i++){
            List<Integer> list = new ArrayList<>();
            for(int ancestor : ancestors.get(i)){
                list.add(ancestor);
            }
            Collections.sort(list);
            result.add(list);
        }

        return result;
    }
}



// jab indegree zero ho chukii hogii tb uske saree parents nipat chuke hogeee
// class Solution {
//     public List<List<Integer>> getAncestors(int n, int[][] edges) {
//         List<List<Integer>> graph = new ArrayList<>();        
//         List<List<Integer>> parents = new ArrayList<>();    
//         List<Set<Integer>> ancestors = new ArrayList<>();
//         int[] indegree = new int[n];

//         for (int i = 0; i < n; i++) {
//             graph.add(new ArrayList<>());
//             parents.add(new ArrayList<>());
//             ancestors.add(new HashSet<>());
//         }

//         for (int[] edge : edges) {
//             int u = edge[0], v = edge[1];
//             graph.get(u).add(v);      
//             parents.get(v).add(u);  
//             indegree[v]++;
//         }

//         Queue<Integer> queue = new LinkedList<>();
//         for (int i = 0; i < n; i++) {
//             if (indegree[i] == 0) queue.add(i);
//         }

//         while (!queue.isEmpty()) {
//             int curr = queue.poll();

            
//             for (int child : graph.get(curr)) {
//                 indegree[child]--;

//                 if (indegree[child] == 0) {
//                     for (int parent : parents.get(child)) {
//                         ancestors.get(child).add(parent);
//                         ancestors.get(child).addAll(ancestors.get(parent));
//                     }
//                     queue.add(child);
//                 }
//             }
//         }

//         List<List<Integer>> ans = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             List<Integer> sortedList = new ArrayList<>(ancestors.get(i));
//             Collections.sort(sortedList);
//             ans.add(sortedList);
//         }

//         return ans;
//     }
// }
