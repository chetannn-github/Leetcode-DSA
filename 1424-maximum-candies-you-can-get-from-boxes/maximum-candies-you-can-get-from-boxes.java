class Solution {
    int totalCandies = 0;
    int[] status,candies; int[][] keys, graph;
    HashSet<Integer> pending = new HashSet<>();
    HashSet<Integer> connected =  new HashSet<>();
     HashSet<Integer> actualPending =  new HashSet<>();
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        HashSet<Integer> visited = new HashSet<>();
        this.status = status;
        this.keys = keys;
        this.candies = candies;
        this.graph = containedBoxes;

        for(int intial : initialBoxes) {
            if(status[intial] == 1 && !visited.contains(intial)) {
                dfs(intial,visited);
            }
            connected.add(intial);
        }
        
        for(int i=0; i<1000; i++){for(int pendingBox : pending) {
            if(!visited.contains(pendingBox) && connected.contains(pendingBox)) {
                actualPending.add(pendingBox);
            }
        }

        for(int box : actualPending) {
            if(!visited.contains(box)) dfs(box,visited);
        }}

        return totalCandies;
    }


    private void dfs(int curr, HashSet<Integer> visited) {
        visited.add(curr);
    
        totalCandies += candies[curr];

        for(int key : keys[curr]) {
            status[key] = 1;
            pending.add(key);
        }

        for(int nbr : graph[curr]) {
            if(status[nbr] == 1 && !visited.contains(nbr)) {
                dfs(nbr,visited);
            }
            connected.add(nbr);
            
        }
    }
}