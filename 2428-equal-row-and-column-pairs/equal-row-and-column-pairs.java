// class Solution {
//     public int equalPairs(int[][] grid) {
//         HashMap<List<Integer> , Integer> hm = new HashMap<>();
//         for(int i=0; i<grid.length; i++){
//             List<Integer> row = new ArrayList<>();
//             for (int j = 0; j < grid[i].length; j++) {
//                 row.add(grid[i][j]);
//             }
//             hm.put(row,hm.getOrDefault(row,0)+1);
//         }

//         // transponse 
//         for(int i=0; i<grid.length; i++){
//             for(int j=i+1; j<grid.length; j++){
//                 grid[i][j] = grid[j][i] ^ grid[i][j];
//                 grid[j][i] = grid[j][i] ^ grid[i][j];
//                 grid[i][j] = grid[j][i] ^ grid[i][j];
//             }
//         }


//         int count = 0;
//         for(int i=0; i<grid.length; i++){
//             List<Integer> row = new ArrayList<>();
//             for (int j = 0; j < grid[i].length; j++) {
//                 row.add(grid[i][j]);
//             }
//             count += hm.getOrDefault(row,0);
//         }

//         return count;
//     }
// }

class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i<grid.length; i++){
            String row = Arrays.toString(grid[i]);
            hm.put(row,hm.getOrDefault(row,0)+1);
        }

        for(int i=0; i<grid.length; i++){
            for(int j=i+1; j<grid.length; j++){
                grid[i][j] = grid[j][i] ^ grid[i][j];
                grid[j][i] = grid[j][i] ^ grid[i][j];
                grid[i][j] = grid[j][i] ^ grid[i][j];
            }
        }

        int count = 0;
        for(int i=0; i<grid.length; i++){
            String row = Arrays.toString(grid[i]);
            count += hm.getOrDefault(row,0);
        }
        return count;
    }
}