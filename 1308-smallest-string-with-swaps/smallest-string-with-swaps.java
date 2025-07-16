class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        DSU dsu = new DSU(n);

        for(List<Integer> pair : pairs) {
            dsu.union(pair.get(0), pair.get(1));
        }

        HashMap<Integer,PriorityQueue<Integer>> hm = new HashMap<>();

        for(int i=0; i<n; i++) {
            int ch = (int) (s.charAt(i) - 'a');
            int parent = dsu.find(i);
            PriorityQueue<Integer> pq = hm.getOrDefault(parent,new PriorityQueue<>());
            pq.add(ch);
            hm.put(parent,pq);
        }

        StringBuilder result = new StringBuilder();
        for(int i=0; i<n; i++) {
            int ch = (int)( s.charAt(i) - 'a');
            int parent = dsu.find(i);

            result.append((char) (hm.get(parent).remove() + 'a'));
        }

        return result.toString();
    }

}

class DSU {
    int[] parent, rank;

    DSU(int size) {
        parent = new int[size];
        rank = new int[size];

        for(int i=0; i<size; i++) {
            parent[i] = i;
        } 
    }


    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if(xParent == yParent) return;

        if(rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        }else if(rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        }else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }

    public int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }


}