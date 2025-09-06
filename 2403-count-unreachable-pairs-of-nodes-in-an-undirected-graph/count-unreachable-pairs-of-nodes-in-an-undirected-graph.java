class Solution {
    public long countPairs(int N, int[][] edges) {
        int[] rank = new int[N];
        int[] parent = new int[N];

        for(int i=0;i<N; i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];

            union(x,y,rank,parent);
        }
        HashMap<Integer,Long> hm = new HashMap<>();

        for(int i=0; i<N; i++){
            int p = find(i,parent);
            hm.put(p ,(long) (hm.getOrDefault(p,0L)+1));
        }
        long result = 0;
        for(int key : hm.keySet()){
            long val = hm.get(key);

            result += (val * (N - val));
            N -= val;
        }

        return result;
    }

    public void union(int x,int y, int[] rank,int[] parent){
        int xParent = find(x,parent);
        int yParent = find(y,parent);

        if(xParent == yParent) return;

        if(rank[xParent] > rank[yParent]){
            parent[yParent] = xParent;
        }else if(rank[xParent] < rank[yParent]){
            parent[xParent] = yParent;
        }else{
            parent[yParent] = xParent;
            rank[xParent]++;
        }
    }

    public int find(int x, int[] parent){
        if(x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x], parent);
    }
}