class Solution {
    int[] parent;
    public String smallestEquivalentString(String s1, String s2, String base) {
        this.parent = new int[26];
        for(int i=0; i<26; i++){
            this.parent[i] = i;
        }

        for(int i=0; i<s1.length(); i++){
            int ch1 = s1.charAt(i) - 'a';
            int ch2 = s2.charAt(i) - 'a';
            union(ch1,ch2);
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<base.length(); i++){
            int ch = base.charAt(i);
            sb.append((char)(find(ch- 'a') + 'a'));
        }

        return sb.toString();
    }


    public void union(int x, int y){
        int xParent = find(x);
        int yParent = find(y);

        if(xParent == yParent) return;

        if(xParent < yParent){
            parent[yParent] = xParent;
        }else{
            parent[xParent] = yParent;
        }
    }

    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}