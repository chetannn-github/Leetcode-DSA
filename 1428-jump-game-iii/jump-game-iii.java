class Solution {
    HashMap<Integer,List<Integer>> adj;
    HashSet<Integer> destinations;
    public boolean canReach(int[] arr, int start) {
        if(arr[start] == 0) return true;

        this.adj = new HashMap<>();
        int length = arr.length;
        destinations = new HashSet<>();

        for(int i=0; i<length; i++) {
            if(arr[i] == 0) destinations.add(i);
            else {
                List<Integer> nbr = adj.getOrDefault(i,new ArrayList<>());
                if (i + arr[i] < length)  nbr.add(i + arr[i]);
                if (i - arr[i] >= 0) nbr.add( i - arr[i]);
                adj.put(i,nbr);
            }
        }
        
        return dfs(start,destinations, new HashSet<>());
    }

    public boolean dfs(int start, HashSet<Integer> destinations, HashSet<Integer> visited) {
        if(destinations.contains(start)) return true;
        visited.add(start);

        for(int nbr : adj.getOrDefault(start, new ArrayList<>())) {
            if(!visited.contains(nbr)) {
                if(dfs(nbr,destinations,visited)) return true;
            }
        }

        return false;
    }
}