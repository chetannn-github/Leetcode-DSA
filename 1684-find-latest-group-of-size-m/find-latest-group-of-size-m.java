class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if(m == n) return n; 

        DSU dsu = new DSU(n);
        int latestStep = -1;

        for(int i = 0; i < n; i++) {
            int idx = arr[i] - 1;

            dsu.size[idx] = 1;
            dsu.sizeMap.put(1, dsu.sizeMap.getOrDefault(1, 0) + 1);

            if(idx > 0 && dsu.size[idx - 1] != 0) {
                dsu.union(idx, idx - 1);
            }

            if(idx < n - 1 && dsu.size[idx + 1] != 0) {
                dsu.union(idx, idx + 1);
            }

            if(dsu.hasSize(m)) {
                latestStep = i + 1;
            }
        }

        return latestStep;
    }
}

class DSU {
    int[] size;
    int[] parent;
    HashMap<Integer, Integer> sizeMap;

    DSU(int n) {
        size = new int[n];
        parent = new int[n];
        sizeMap = new HashMap<>();

        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 0;
        }
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if(px == py) return;

        int sizeX = size[px];
        int sizeY = size[py];

        
        sizeMap.put(sizeX, sizeMap.get(sizeX) - 1);
        sizeMap.put(sizeY, sizeMap.get(sizeY) - 1);
        if(sizeMap.containsKey(sizeY) && sizeMap.get(sizeX) == 0) sizeMap.remove(sizeX);
        if(sizeMap.containsKey(sizeY) && sizeMap.get(sizeY) == 0) sizeMap.remove(sizeY);

        if(sizeX > sizeY) {
            parent[py] = px;
            size[px] = sizeX + sizeY;
            sizeMap.put(size[px], sizeMap.getOrDefault(size[px], 0) + 1);
        } else {
            parent[px] = py;
            size[py] = sizeX + sizeY;
            sizeMap.put(size[py], sizeMap.getOrDefault(size[py], 0) + 1);
        }
    }

    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean hasSize(int n) {
        return sizeMap.getOrDefault(n, 0) > 0;
    }
}
