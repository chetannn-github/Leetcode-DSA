class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] rank = new int[26];
        int[] parent = new int[26];

        for(int i=0; i<26;i++){
            parent[i] = i;
        }
        for(String eq : equations){
            int ch1 = eq.charAt(0) - 'a';
            int ch2 = eq.charAt(3) -'a';
            if(eq.charAt(1) == '='){
                union(ch1,ch2, rank,parent);
            }
        }

        for(String eq : equations){
            int ch1 = eq.charAt(0) - 'a';
            int ch2 = eq.charAt(3) -'a';
            if(eq.charAt(1) == '!'){
                if(find(ch1,parent) == find(ch2,parent)) return false;
            }
        }

        return true;
    }

    public void union(int x, int y,int[] rank, int[] parent){
        int xParent = find(x,parent);
        int yParent = find(y,parent);

        if(xParent == yParent) return;

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
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x], parent);
    }
}