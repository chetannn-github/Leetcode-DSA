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



// class Solution {
//     public int removeStones(int[][] stones) {
//         DSU dsu = new DSU(2002);

//         for (int[] stone : stones) {
//             int row = stone[0];
//             int col = stone[1] + 1001;
//             dsu.union(row, col);
//         }

//         Set<Integer> uniqueRoots = new HashSet<>();
//         for (int[] stone : stones) {
//             uniqueRoots.add(dsu.find(stone[0]));
//         }

//         return stones.length - uniqueRoots.size();
//     }
// }


class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        DSU dsu = new DSU(n);

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                boolean isSameRowOrCol = (
                    stones[i][0] == stones[j][0]  || 
                    stones[i][1] == stones[j][1]
                );
                if(isSameRowOrCol) dsu.union(i,j);
            }
        }

        Set<Integer> uniqueRoots = new HashSet<>();
        for (int i=0; i<n; i++) {
            uniqueRoots.add(dsu.find(i));
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
