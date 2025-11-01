// TLE
// class Solution {
//     List<Integer>[] graph;
//     int goodPaths = 0;
//     int maxVal, maxValNode;
//     public int numberOfGoodPaths(int[] vals, int[][] edges) {
//         buildGraphAndCalcMaxNodeVal(edges, vals);
//         dfs(maxValNode,-1, new HashSet<>(),new HashMap<>(),vals);
            
//         return goodPaths + vals.length;
//     }

//     public void buildGraphAndCalcMaxNodeVal(int[][] edges, int[] vals) {
//         int n = vals.length;
//         graph = new List[n];
//         maxValNode = 0;
//         maxVal = vals[0];

//         for(int i=0; i<n; i++) {
//             graph[i] = new ArrayList<>();
//             if(vals[i] > maxVal) {
//                 maxValNode = i;
//                 maxVal = vals[i];
//             }
//         }

//         for(int[] edge : edges) {
//             int u = edge[0], v = edge[1];
//             graph[u].add(v);
//             graph[v].add(u);
//         }
//     }

//     public void dfs(int curr,int parent, HashSet<Integer> visited, HashMap<Integer,Integer> nodes, int[] vals) {
//         visited.add(curr);

//         goodPaths += nodes.getOrDefault(vals[curr], 0);
//         nodes.put(vals[curr], nodes.getOrDefault(vals[curr], 0) + 1);

//         HashMap<Integer,Integer> newNodes = new HashMap<>();
//         for(int key : nodes.keySet()) {
//             if(key >= vals[curr]) {
//                 newNodes.put(key,nodes.get(key));
//             }
//         }

//         for(int nbr : graph[curr]) {
//             if(!visited.contains(nbr)) {
//                 dfs(nbr,curr, visited, newNodes,vals);
//             }
//         }

//         if(parent != -1) {
//             for(int key : newNodes.keySet()) {
//                 if(key >= vals[parent]) {
//                     nodes.put(key,newNodes.get(key));
//                 }
//             }
//         }
//         if(parent != -1 && vals[curr] < vals[parent]) nodes.remove(vals[curr]);
//     }
// }



class Solution {
    List<Integer>[] graph;
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        DSU dsu = new DSU(n);
        TreeMap<Integer,List<Integer>> valToNode = new TreeMap<>();
        int paths = 0;

        buildGraph(n,edges);
        for(int i=0; i<n; i++) {
            int val = vals[i];
            List<Integer> nodes = valToNode.getOrDefault(val,new ArrayList<>());
            nodes.add(i);
            valToNode.put(val,nodes);
        }

        for(int val : valToNode.keySet()) {
            List<Integer> nodes = valToNode.get(val);
            for(int node : nodes) dsu.active(node);

            for(int node : nodes) {
                for(int nbr : graph[node]) {
                    dsu.union(node,nbr);
                }
            }
            HashMap<Integer,Integer> parent = new HashMap<>();
            for(int node : nodes) {
                int p = dsu.find(node);
                paths += parent.getOrDefault(p,0);
                parent.put(p,parent.getOrDefault(p,0)+1);
            }

            
        }
        return n + paths;
    }

    public void buildGraph(int n,int[][] edges) {
        graph = new List[n];
        
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
    
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
    }
}

class DSU {
    int[] parent;
    int[] rank;
    boolean[] isActive;
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        isActive = new boolean[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY) return false;
        if(!isActive[x] || !isActive[y]) return false;

        if(rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        }else if (rank[rootY] < rank[rootX]) {
            parent[rootY] = rootX;
        }else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        return true;
    }

    public void active(int x) {
        isActive[x] = true;
    }
}
