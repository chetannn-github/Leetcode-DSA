class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[][] minDist = floydWarshall(n,x,y);

        int ans[] = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(minDist[i][j] == 0) continue;
                ans[minDist[i][j]-1]++;
            }
        }
        return ans;
    }

    private int[][] floydWarshall(int n, int x, int y) {
        int[][] minDist = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                minDist[i][j] = Math.abs(i-j);
            }
        }
        if(x != y ){
            minDist[x-1][y-1] = 1;
            minDist[y-1][x-1] = 1;
        }
        
        for(int via = 0; via <n; via++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(minDist[i][via] + minDist[via][j] < minDist[i][j]){
                        minDist[i][j] = minDist[i][via] + minDist[via][j];
                    }
                }
            }
        }
        return minDist;
    }
}


// dimag me aata hain a ke nbr uske bade wale hii banae aurr double krr lenge value koo but wo glt hain kukii wo jldi aage jaakrr peeche aasktaa hain assume 1 --> 100 ek connection hain toh wo peeche jaakr help kregaa bro
// class Solution {
//     int result[];
//     List<Integer>[] graph;
//     public int[] countOfPairs(int n, int x, int y) {
//         constructGraph(n,x,y);
//         result = new int[n];
        
//         for(int i=0; i<n; i++) {
//             bfs(i);
//         }

//         return result;
//     }

//     public void bfs(int start) {
//         Queue<Integer> queue = new LinkedList<>();
//         HashSet<Integer> visited = new HashSet<>(); 
//         queue.add(start); 
//         visited.add(start);

//         int count = 0;

//         while(!queue.isEmpty()) {
//             int n = queue.size();

//             while(n-->0) {
//                 int curr = queue.remove();
                
//                 for(int nbr : graph[curr]) {
//                     if(!visited.contains(nbr)) {
//                         queue.add(nbr);
//                         visited.add(nbr);
//                     }
//                 }
                
//             }
            
//             result[count++] += queue.size();
//         }
//     }


//     public void constructGraph(int n, int x, int y) {
//         graph = new List[n];

//         for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

//         for(int i=0; i<n; i++) {
//             if(x != y) {
//                 if(i == x-1) graph[i].add(y-1);
//                 if(i == y-1) graph[i].add(x-1);
//             }
//             if(i<n-1) graph[i].add(i+1);
//             if(i>0)  graph[i].add(i-1);
//         }
//     }
// }





