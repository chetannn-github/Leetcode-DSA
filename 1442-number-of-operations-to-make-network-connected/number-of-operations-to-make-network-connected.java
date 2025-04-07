class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n -1) return -1;
        int[] rank = new int[n];
        int[] parent = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        for(int[] edge : connections){
            int x = edge[0];
            int y = edge[1];
            int xParent = find(x, parent);
            int yParent = find(y,parent);

            if(xParent != yParent){
                union(x,y,rank,parent);
                
            }
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<n; i++){
            hs.add(find(i,parent));
        }

        return hs.size()-1;

    }

    public void union(int x, int y, int[] rank, int[] parent){
        int xParent = find(x,parent);
        int yParent = find(y,parent);

        if(rank[xParent] > rank[yParent]){
            parent[yParent] = xParent;
        }else if(rank[xParent] < rank[yParent]){
            parent[xParent] = yParent;
        }else{
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }

    public int find(int x, int[] parent){
        if(x == parent[x]) return x;

        return parent[x] = find(parent[x], parent);
    }
}