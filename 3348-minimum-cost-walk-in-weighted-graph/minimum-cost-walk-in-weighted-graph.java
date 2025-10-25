class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DSU dsu = new DSU(n);
        int[] result = new int[query.length];
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            dsu.union(u,v, wt);
        }

        for(int i=0; i<query.length; i++) {
            int u = query[i][0], v = query[i][1];
            boolean isConnected = dsu.find(u) == dsu.find(v);
            result[i] = isConnected ? dsu.cumAND[dsu.find(u)] : -1;
        }

        
        return result;
    }
}


class DSU {
    int[] parent;
    int[] rank;
    int[] cumAND;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        cumAND = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
            cumAND[i] = (1 << 31) - 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int x, int y, int wt) {
        int px = find(x);
        int py = find(y);

        if (rank[px] < rank[py]) {
            parent[px] = py;
            cumAND[py] &= (wt & cumAND[px]);
        }
        else if (rank[px] > rank[py]) {
            parent[py] = px;
            cumAND[px] &= (wt & cumAND[py]);
        }
        else {
            parent[py] = px;
            rank[px]++;
            cumAND[px] &= (wt & cumAND[py]);
        }
        return true;
    }
}
