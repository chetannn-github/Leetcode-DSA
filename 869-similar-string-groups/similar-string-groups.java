class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DSU dsu = new DSU(n);

        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                dsu.union(i,j, strs);
            }
        }

        HashSet<Integer> groups = new HashSet<>();

        for(int i=0; i<n; i++) {
            groups.add(dsu.find(i));
        }

        return groups.size();
    }
}


class DSU {
    int[] parent, rank ;
    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    void union(int x, int y, String[] strs) {
        int px = find(x);
        int py = find(y);

        if(px == py) return;

        if(!isSimilar(strs[x], strs[y])) return;

        if(rank[px] > rank[py]) {
            parent[py] = px;
        }else if(rank[px] < rank[py]) {
            parent[px] = py;
        }else {
            parent[py] = px;
            rank[px]++;
        }
    }


    boolean isSimilar(String x, String y) {
        if(x.equals(y)) return true;

        int firstWrongIdx = -1;
        for(int i=0; i<x.length(); i++) {
            char ch1 = x.charAt(i), ch2 = y.charAt(i);

            if(ch1 != ch2) {
                if(firstWrongIdx == -1) firstWrongIdx = i;
                else {
                    if(firstWrongIdx == -2) return false;
                    else if(x.charAt(firstWrongIdx) == ch2 && ch1 == y.charAt(firstWrongIdx)) {
                        firstWrongIdx = -2;
                    }else return false;
                }
            }
        }

        return firstWrongIdx == -2;
    }
}