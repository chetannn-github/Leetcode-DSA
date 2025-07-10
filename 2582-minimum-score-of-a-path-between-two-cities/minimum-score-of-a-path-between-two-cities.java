class Solution {
    public int minScore(int n, int[][] roads) {
        // 1 se bfs/dfs maroo aur jis node kii value minmum hain whi answer hainn broo
        // kuki hum path overlap krr skte hain
        int min = Integer.MAX_VALUE;
        List<List<List<Integer>>> adj = new ArrayList<>();

        for(int i=0; i<n+1;i++) adj.add(new ArrayList<>());

        int minDistanceBtwAllRoads = Integer.MAX_VALUE;
        for(int[] road : roads){
            List<Integer> ls = new ArrayList<>();
            ls.add(road[1]);
            ls.add(road[2]);
            adj.get(road[0]).add(ls); 
            
            minDistanceBtwAllRoads = Math.min(minDistanceBtwAllRoads,road[2]);
            ls = new ArrayList<>();
            ls.add(road[0]);
            ls.add(road[2]);
            adj.get(road[1]).add(ls);
        }
        
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited.add(1);

        while(!queue.isEmpty()){
            int curr = queue.remove();
        
            for(List<Integer> nbr : adj.get(curr)){
                int v = nbr.get(0);
                int amt = nbr.get(1);
                min = Math.min(min,amt);

                if(min == minDistanceBtwAllRoads) return min; // early exit

                if(!visited.contains(v)){
                    queue.add(v);
                    visited.add(v);
                }
            }
        }
        return min;
        
    }
}




// class Solution {
//     public int minScore(int n, int[][] roads) {
//         int min = Integer.MAX_VALUE;
//         List<List<List<Integer>>> adj = new ArrayList<>();

//         for(int i=0; i<n+1;i++) adj.add(new ArrayList<>());

//         for(int[] road : roads){
//             List<Integer> ls = new ArrayList<>();
//             ls.add(road[1]);
//             ls.add(road[2]);
//             adj.get(road[0]).add(ls); 
            
//             ls = new ArrayList<>();
//             ls.add(road[0]);
//             ls.add(road[2]);
//             adj.get(road[1]).add(ls);
//         }


        
//         for(int i=1; i<=n; i++){
//             int[] dis = new int[n+1];
//             Arrays.fill(dis,Integer.MAX_VALUE);
//             HashSet<Integer> visited = new HashSet<>();
//             PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (a[1] - b[1]));
//             pq.add(new int[]{i,Integer.MAX_VALUE});
//             visited.add(i);

//             while(!pq.isEmpty()){
//                 int curr[] = pq.remove();
//                 int u = curr[0];
//                 int minD = curr[1];

//                 for(List<Integer> nbr : adj.get(curr[0])){
//                     int v = nbr.get(0);
//                     int amt = nbr.get(1);

//                     if(Math.min(minD,amt) < dis[v]){
//                         dis[v] = Math.min(minD,amt);
//                         pq.add(new int[]{v,dis[v]});
//                     }
//                 }
//             }
//             min = Math.min(min,dis[n]);
//         }

//         return min;
//     }
// }