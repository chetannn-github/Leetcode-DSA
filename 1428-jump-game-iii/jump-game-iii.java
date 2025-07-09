class Solution {
    HashMap<Integer,List<Integer>> adj;
    HashSet<Integer> dest;
    public boolean canReach(int[] arr, int start) {
        if(arr[start] == 0) return true;

        this.adj = new HashMap<>();
        int length = arr.length;
        dest = new HashSet<>();

        for(int i=0; i<length; i++) {
            if(arr[i] == 0) dest.add(i);
            else {List<Integer> nbr = adj.getOrDefault(i,new ArrayList<>());
                if (i + arr[i] < length)  nbr.add(i + arr[i]);
                if (i - arr[i] >= 0) nbr.add( i - arr[i]);
                adj.put(i,nbr);
            }
        }
        
        return dfs(start,dest, new HashSet<>());
    }

    public boolean dfs(int start, HashSet<Integer> dest, HashSet<Integer> visited) {
        if(dest.contains(start)) return true;
        visited.add(start);

        for(int nbr : adj.getOrDefault(start, new ArrayList<>())) {
            if(!visited.contains(nbr)) {
                if(dfs(nbr,dest,visited)) return true;
            }
        }

        return false;
    }
}