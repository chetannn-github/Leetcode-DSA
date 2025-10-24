class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);
        int[] indegree = new int[n];
        int possibleAnsOne = -1;
        int possibleAnsTwo = -1;
        int twoIndegreeNode = 0;

        for(int i=0; i<n; i++){
            int v = edges[i][1] - 1;
            indegree[v]++;
            if(indegree[v] == 2) {
                possibleAnsTwo = i;
                twoIndegreeNode = v;
            }
        }
        
        for(int i=0; i<n; i++){
            int v = edges[i][1] - 1;
            
            if(indegree[v] == 2) {
                possibleAnsOne = i;
                break;
            }
        }    

        for(int i=0; i<n; i++) {
            if(i == possibleAnsTwo) continue;
            int u = edges[i][0] -1 , v = edges[i][1] - 1;

            if(!dsu.union(u,v)) {
                return possibleAnsOne == -1 ? edges[i] : edges[possibleAnsOne];
            }
        }
        return edges[possibleAnsTwo];
    }

    
}


class DSU {
    int n;
    int[] parent;
    int[] rank;

    DSU(int size) {
        parent = new int[size];
        rank = new int[size];
        n = size;
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }

    public boolean union(int x, int y){
        int xParent = find(x);
        int yParent = find(y);

        if(xParent == yParent) return false;

        if(rank[xParent] > rank[yParent]){
            parent[yParent] = xParent;
        }else if(rank[xParent] < rank[yParent]){
            parent[xParent] = yParent;
        }else{
            parent[yParent] = xParent;
            rank[xParent]++;
        }
        return true;
    }

    public int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    
}