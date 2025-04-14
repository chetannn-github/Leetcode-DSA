class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int max = 1;
        for(int[] edge : edges){
            max = Math.max(max,edge[0]);
            max = Math.max(max,edge[1]);
        }
        parent = new int[max+1];
        rank = new int[max+1];
        for(int i=0; i<max+1; i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            if(!union(edge[0], edge[1])){
                return edge;
            }
        }

        return new int[]{-1,-1};
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