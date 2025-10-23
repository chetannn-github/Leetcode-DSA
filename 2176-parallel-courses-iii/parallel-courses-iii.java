// this fails because yeh koi college sem nhi hain agr tumne pre requisite pura krr liya toh tum lelo next course no need to learn in batches 
// class Solution {
//     public int minimumTime(int n, int[][] edges, int[] time) {
//         int[] indegree = new int[n];
//         List<Integer>[] graph = new ArrayList[n];
//         Queue<Integer> queue = new LinkedList<>();

//         for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        
//         for(int[] edge : edges) {
//             int u = edge[0]-1, v = edge[1]-1;
//             graph[u].add(v);
//             indegree[v]++;
//         }

//         for(int i=0; i<n; i++) {
//             if(indegree[i] == 0) queue.add(i);
//         }

//         int monthsPassed = 0;
//         while(!queue.isEmpty()) {
//             int currSize = queue.size();
//             int maxMonths = Integer.MIN_VALUE;
//             while(currSize-->0) {
//                 int curr = queue.remove();
//                 maxMonths = Math.max(maxMonths,time[curr]);
//                 for(int nbr : graph[curr]) {
//                     if(--indegree[nbr] == 0) {
//                         queue.add(nbr);
//                     }
//                 }
//             }

//             monthsPassed += maxMonths;
//         }
//         return monthsPassed;
//     }
// }


class Solution {
    public int minimumTime(int n, int[][] edges, int[] time) {
        int[] indegree = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        
        for(int[] edge : edges) {
            int u = edge[0]-1, v = edge[1]-1;
            graph[u].add(v);
            indegree[v]++;
        }
        int[] maxMonths = new int[n];
        int totalMaxMonths = 0;
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0) queue.add(i);
            maxMonths[i] = time[i];
            totalMaxMonths = Math.max(totalMaxMonths, maxMonths[i]);
        }

        while(!queue.isEmpty()) {
            int curr = queue.remove();

            for(int nbr : graph[curr]) {
                maxMonths[nbr] = Math.max(maxMonths[nbr], maxMonths[curr] + time[nbr]);
                totalMaxMonths = Math.max(totalMaxMonths, maxMonths[nbr]);

                if(--indegree[nbr] == 0) {
                    queue.add(nbr);
                }
            }
        
        }
        return totalMaxMonths;
    }
}