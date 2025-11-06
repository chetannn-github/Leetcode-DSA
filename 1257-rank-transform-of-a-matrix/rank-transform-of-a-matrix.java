class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        TreeMap<Integer, List<Pair>> valueGroups = new TreeMap<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                List<Pair> indices = valueGroups.getOrDefault(matrix[i][j], new ArrayList<>());
                indices.add(new Pair(i, j));
                valueGroups.put(matrix[i][j], indices);
            }
        }

        int[] rowRank = new int[m];
        int[] colRank = new int[n];
        int[][] result = new int[m][n];

        for(int val : valueGroups.keySet()) {
            DSU dsu = new DSU(m + n);
            List<Pair> cells = valueGroups.get(val);

            for(Pair c : cells) {
                int x = c.x, y = c.y;
                dsu.union(x, y + m);
            }

            Map<Integer, Integer> compRank = new HashMap<>();

            for(Pair c : cells) {
                int x = c.x, y = c.y;
                int parent = dsu.find(x);
                
                int rank = Math.max(rowRank[x], colRank[y]) + 1;
                compRank.put(parent, Math.max(compRank.getOrDefault(parent, 0), rank));
            }

            for(Pair c : cells) {
                int x = c.x, y = c.y;
                int parent = dsu.find(x);
                int rank = compRank.get(parent);
                
                result[x][y] = rank;
                rowRank[x] = Math.max(rowRank[x], rank);
                colRank[y] = Math.max(colRank[y], rank);
            }
        }

        return result;
    }
}

class DSU {
    int[] parent, rank;
    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    int find(int x) {
        if (x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }
    void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
