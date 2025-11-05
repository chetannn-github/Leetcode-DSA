class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> critical = new ArrayList<>();
        List<Integer> psuedo = new ArrayList<>();
        
        int[][] modEdges = addIndexAndSort(edges);

        int MST = calculateMST(modEdges, n, -1, -1);

        for(int i=0; i<modEdges.length; i++) {
            int idx = modEdges[i][3];
            if (isCritical(modEdges,n,i,MST)) critical.add(idx);
            else if (isPsuedo(modEdges,n,i,MST)) psuedo.add(idx);
        }

        result.add(critical);
        result.add(psuedo);
        return result;
    }

    private int[][] addIndexAndSort(int[][] arr) {
        int n = arr.length;
        int[][] newArr = new int[n][4];

        for(int i=0; i<n; i++) {
            newArr[i][0] = arr[i][0];
            newArr[i][1] = arr[i][1];
            newArr[i][2] = arr[i][2];
            newArr[i][3] = i;
        }

        Arrays.sort(newArr, (a,b)->(a[2]-b[2]));

        return newArr;
    }

    private boolean isCritical(int[][] edges, int n, int idx, int MST) {
        return calculateMST(edges, n, -1, idx) > MST;
    }

    private boolean isPsuedo(int[][] edges,int n, int idx, int MST) {
        return calculateMST(edges, n, idx, -1) == MST;
    }

    private int calculateMST(int[][] edges, int n, int include, int exclude) {
        DSU dsu = new DSU(n);
        int MST = 0, edgesAdded = 0;

        if(include != -1) {
            int u = edges[include][0], v = edges[include][1], wt = edges[include][2];
            dsu.union(u,v);
            edgesAdded++;
            MST += wt;
        }

        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0], v = edges[i][1], wt= edges[i][2];
            if(exclude == i) continue;
            if(dsu.isConnected(u,v)) continue;

            dsu.union(u,v);
            MST += wt;
            edgesAdded++;
        }

        return edgesAdded == n-1 ? MST : Integer.MAX_VALUE;
    }
}

class DSU {
    int[] parent, rank;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if(px == py) return;

        if(rank[px] > rank[py]) {
            parent[py] = px;
        }else if(rank[px] < rank[py]) {
            parent[px] = py;
        }else {
            parent[px] = py;
            rank[py]++;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
