// class Solution {
//     int n;HashSet<Integer> visited;
//     public int removeStones(int[][] stones) {
//         int groups = 0;
//         n = stones.length;
//         visited = new HashSet<>();

//         for(int i=0; i<n; i++){
//             if(!visited.contains(i)){
//                 dfs(stones,i);
//                 groups++;
//             }
//         }

//         return n - groups;
//     }

//     public void dfs(int[][] stones,int curr){
//         visited.add(curr);

//         for(int i=0; i<n; i++){
//             if(!visited.contains(i) && (stones[curr][0] == stones[i][0]  || stones[curr][1] == stones[i][1] )){
//                 dfs(stones,i);
//             }
//         }
//     }
// }



class Solution {
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU(20002); // rows: 0-10000, cols: 10001-20001

        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + 10001; // offset to avoid collision
            dsu.union(row, col);
        }

        // Count number of unique connected components
        Set<Integer> uniqueRoots = new HashSet<>();
        for (int[] stone : stones) {
            uniqueRoots.add(dsu.find(stone[0]));
        }

        return stones.length - uniqueRoots.size();
    }
}

class DSU {
    int[] parent;
    int[] rank;

    public DSU(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;

        // union by rank
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }
}
