class Solution {
    List<HashSet<Integer>> subsets = new ArrayList<>();
    int MAX = Integer.MAX_VALUE;
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        findSubsets(n);

        int result = 0;
        for(HashSet<Integer> set : subsets) {
            int[][] dist = floydWarshall(n,set,roads);
            if(check(dist,maxDistance,n,set)) {
                result++;
            }
        }

        return result;
    }

    private void findSubsets(int n) {
        solve(n, 0, new HashSet<>());
    }

    private void solve(int n, int curr, HashSet<Integer> set) {
        if(curr == n) {
            HashSet<Integer> currSet = new HashSet<>();
            currSet.addAll(set);
            subsets.add(currSet);
            return;
        }

        set.add(curr);
        solve(n,curr+1,set);
        set.remove(curr);
        solve(n,curr+1,set);
    }

    

    private int[][] floydWarshall(int n,HashSet<Integer> removed,int[][] edges) {
        int[][] dist = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], MAX);
            dist[i][i] = 0;
        }
        for(int[] edge : edges) {
            int u = edge[0], v= edge[1], wt = edge[2];
            if(removed.contains(u) || removed.contains(v)) continue;

            dist[u][v] = Math.min(dist[u][v], wt);
            dist[v][u] = Math.min(dist[v][u], wt);
        }

        for(int via = 0; via<n; via++) {
            if(removed.contains(via)) continue;
            for(int i=0; i<n; i++) {
                if (removed.contains(i)) continue;
                for(int j=0; j<n; j++) {
                    if (removed.contains(j)) continue;
                    boolean isConnected = dist[i][via] != MAX && dist[via][j] != MAX;
                    boolean isFavourable = isConnected && (
                        dist[i][j] > dist[i][via] + dist[via][j]
                    );

                    if(isFavourable) {
                        dist[i][j] = dist[i][via] + dist[via][j];
                    }
                }
            }
        }
        return dist;
    }

    private boolean check(int[][] grid, int threshold,int n, HashSet<Integer> removed) {
         for(int i=0; i<n; i++) {
                if (removed.contains(i)) continue;
                for(int j=0; j<n; j++) {
                    if (removed.contains(j)) continue;
                    if(grid[i][j] > threshold) return false;
                }
            }
        return true;
    }

}


class Pair{
    int node,wt;
    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}