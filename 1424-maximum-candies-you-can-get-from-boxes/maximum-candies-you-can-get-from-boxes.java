// class Solution {
//     int totalCandies = 0;
//     int[] status,candies; int[][] keys, graph;
//     HashSet<Integer> pending = new HashSet<>();
//     HashSet<Integer> connected =  new HashSet<>();
//      HashSet<Integer> actualPending =  new HashSet<>();
//     public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
//         HashSet<Integer> visited = new HashSet<>();
//         this.status = status;
//         this.keys = keys;
//         this.candies = candies;
//         this.graph = containedBoxes;

//         for(int intial : initialBoxes) {
//             if(status[intial] == 1 && !visited.contains(intial)) {
//                 dfs(intial,visited);
//             }
//             connected.add(intial);
//         }
        
//         for(int i=0; i<999; i++)
//         {for(int pendingBox : pending) {
//             if(!visited.contains(pendingBox) && connected.contains(pendingBox)) {
//                 actualPending.add(pendingBox);
//             }
//         }

//         for(int box : actualPending) {
//             if(!visited.contains(box)) dfs(box,visited);
//         }}

//         return totalCandies;
//     }


//     private void dfs(int curr, HashSet<Integer> visited) {
//         visited.add(curr);
    
//         totalCandies += candies[curr];

//         for(int key : keys[curr]) {
//             status[key] = 1;
//             pending.add(key);
//         }

//         for(int nbr : graph[curr]) {
//             if(status[nbr] == 1 && !visited.contains(nbr)) {
//                 dfs(nbr,visited);
//             }
//             connected.add(nbr);
            
//         }
//     }
// }


class Solution {

    public int dfs(int box, int[] status, int[] candies,
        int[][] keys, int[][] containedBoxes,
        Set<Integer> visited, Set<Integer> foundBoxes) {
        
        if (visited.contains(box)) {
            return 0;
        }

        if (status[box] == 0) {
            foundBoxes.add(box);
            return 0;
        }

        visited.add(box);
        int candiesCollected = candies[box];

        for (int innerBox : containedBoxes[box]) {
            candiesCollected += dfs(innerBox, status, candies, keys, containedBoxes, visited, foundBoxes);
        }

        for (int boxKey : keys[box]) {
            status[boxKey] = 1; // mark as openable
            if (foundBoxes.contains(boxKey)) {
                candiesCollected += dfs(boxKey, status, candies, keys, containedBoxes, visited, foundBoxes);
            }
        }

        return candiesCollected;
    }

    public int maxCandies(int[] status, int[] candies,
                          int[][] keys, int[][] containedBoxes,
                          int[] initialBoxes) {

        int candiesCollected = 0;
        Set<Integer> visited = new HashSet<>();
        Set<Integer> foundBoxes = new HashSet<>();

        for (int box : initialBoxes) {
            candiesCollected += dfs(box, status, candies, keys, containedBoxes, visited, foundBoxes);
        }

        return candiesCollected;
    }
}
