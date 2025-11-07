class Solution {
    public boolean gcdSort(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int num : nums) max = Math.max(max, num);

        DSU dsu = new DSU(max + 1);

        for(int num : nums) {
            int x = num;
            for(int i=2; i*i <= x; i++) {
                if(x % i == 0) {
                    dsu.union(num, i);
                    while (x % i == 0) x /= i;
                }
            }
            if (x > 1) dsu.union(num, x);
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        for(int i = 0; i < n; i++) {
            if(dsu.find(nums[i]) != dsu.find(sorted[i])) {
                return false;
            }
        }

        return true;
    }
}

class DSU {
    int[] parent;
    int[] rank;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;

        if(rank[px] < rank[py]) {
            parent[px] = py;
        }else if (rank[py] < rank[px]) {
            parent[py] = px;
        }else {
            parent[py] = px;
            rank[px]++;
        }
    }
}