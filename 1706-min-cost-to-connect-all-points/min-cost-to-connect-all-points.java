// prims w/o key array
// isme hum pq me unnecessary edges daalegee jo code ko slow krr rha hh 
// class Solution {
//     public int minCostConnectPoints(int[][] points) {
//         int n = points.length;
//         List<List<List<Integer>>> adj = new ArrayList<>();

//         for(int i=0; i<n;i++) adj.add(new ArrayList<>());

//         for(int i=0; i<n; i++){
//             for(int j=i+1; j<n; j++){
//                 int x1 = points[i][0];
//                 int x2 = points[j][0];
//                 int y1 = points[i][1];
//                 int y2 = points[j][1];

//                 int wt = Math.abs(x1-x2) + Math.abs(y1-y2);
                
//                 adj.get(i).add(Arrays.asList(j,wt));
//                 adj.get(j).add(Arrays.asList(i,wt));
//             }
//         }

//         return prims(adj,n);
//     }


//     public int prims(List<List<List<Integer>>> adj,int n){
//         boolean[] inMST = new boolean[n];
//         int sum = 0;
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
//         pq.add(new int[]{0,0});
        

//         while(!pq.isEmpty()){
//             int[] curr = pq.remove();
//             int u = curr[0];
//             int wt = curr[1];

//             if(inMST[u]) continue;
//             inMST[u] = true;
//             sum += wt;

//             for(List<Integer> nbr : adj.get(u)){
//                 int v = nbr.get(0);
//                 int w = nbr.get(1);

//                 if(!inMST[v]){
//                     pq.add(new int[]{v,w});
//                 }
//             }

//         }
//         return sum;
//     }
// }



class Solution {
    int[] key;
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        key = new int[n];
        Arrays.fill(key,Integer.MAX_VALUE);
        List<List<List<Integer>>> adj = new ArrayList<>();

        for(int i=0; i<n;i++) adj.add(new ArrayList<>());

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int x1 = points[i][0];
                int x2 = points[j][0];
                int y1 = points[i][1];
                int y2 = points[j][1];

                int wt = Math.abs(x1-x2) + Math.abs(y1-y2);
                
                adj.get(i).add(Arrays.asList(j,wt));
                adj.get(j).add(Arrays.asList(i,wt));
            }
        }

        return prims(adj,n);
    }


    public int prims(List<List<List<Integer>>> adj,int n){
        boolean[] inMST = new boolean[n];
        int sum = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        pq.add(new int[]{0,0});
        

        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            int u = curr[0];
            int wt = curr[1];

            if(inMST[u]) continue;
            inMST[u] = true;
            sum += wt;

            for(List<Integer> nbr : adj.get(u)){
                int v = nbr.get(0);
                int w = nbr.get(1);

                if(!inMST[v] && w < key[v]){
                    key[v] = w;
                    pq.add(new int[]{v,w});
                }
            }

        }
        return sum;
    }
}