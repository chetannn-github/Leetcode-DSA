class Solution {
    public int[] processQueries(int n, int[][] edges, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        DSU dsu = new DSU(n);

        for(int[] edge : edges) {
            int u = edge[0]-1, v = edge[1]-1;
            dsu.union(u,v);
        }
        dsu.computeMap();

        HashSet<Integer> offline= new HashSet<>();
        HashSet<Integer> toBeRemoved = new HashSet<>();
        for(int[] query : queries) {
            int type = query[0], station = query[1]-1;

            if(type == 2) {
                offline.add(station);
                toBeRemoved.add(station);
            }else {
                if(!offline.contains(station)) {
                    result.add(station+1);
                }else {
                    int parent = dsu.find(station);
                    PriorityQueue<Integer> siblings = dsu.map.get(parent);
                    while(!siblings.isEmpty() && !toBeRemoved.isEmpty() && toBeRemoved.contains(siblings.peek())) {
                        toBeRemoved.remove(siblings.peek());
                        siblings.remove();
                    }
                    dsu.map.put(parent,siblings);

                    int queryResult = siblings.isEmpty() ? -1 : siblings.peek() + 1;
                    result.add(queryResult);
                }
            }
        }

        return toArray(result);
    }

    public int[] toArray(List<Integer> list) {
        int n = list.size();
        int[] result = new int[n];
        for(int i = 0; i<n; i++) result[i] = list.get(i);
        return result;
    }
}


public class DSU {
    private int[] parent;
    int n;
    HashMap<Integer,PriorityQueue<Integer>> map = new HashMap<>();

    public DSU(int n) {
        this.n = n;
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false;

        if(px > py) {
            parent[px] = py;
        } else {
            parent[py] = px;
        }
        return true;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public void computeMap() {
        for(int i=0; i<n; i++) {
            int parent = find(i);
            PriorityQueue<Integer> siblings= map.getOrDefault(parent, new PriorityQueue<>());
            siblings.add(i);
            map.put(parent,siblings);
        }
    }
}

