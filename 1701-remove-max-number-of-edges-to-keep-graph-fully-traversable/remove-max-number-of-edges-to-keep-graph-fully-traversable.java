class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n );
        DSU bob = new DSU(n);

        Arrays.sort(edges, (a,b) -> (b[0] - a[0]));
        int removedEdges = 0;

        for(int[] edge : edges) {
            int u = edge[1] - 1, v = edge[2] - 1, type = edge[0];
            if(type == 3) {
                if(!alice.isConnected(u,v)) {
                    alice.union(u,v);
                    bob.union(u,v);
                }else removedEdges++;
            }else if(type == 2) {
                if(!bob.isConnected(u,v)) {
                    bob.union(u,v);
                }else removedEdges++;
            }else {
                if(!alice.isConnected(u,v)) {
                    alice.union(u,v);
                }else removedEdges++;
            }
        } 
        int bobFather = bob.find(0);
        int aliceFather = alice.find(0);

        for(int i=0; i<n; i++) {
            if(bobFather != bob.find(i)) return -1;
            if(aliceFather != alice.find(i)) return -1;
        }
        return removedEdges;
    }
}

class DSU {
    private int[] parent;
    private int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i; 
            rank[i] = 1; 
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return; 

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
