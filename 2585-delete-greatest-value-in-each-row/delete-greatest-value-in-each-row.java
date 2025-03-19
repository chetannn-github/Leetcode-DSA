// class Solution {
//     public int deleteGreatestValue(int[][] grid) {
//         int rows = grid.length;
//         int cols = grid[0].length;

//         for(int[] row : grid){
//             Arrays.sort(row);
//         }

//         for(int i=0; i<cols; i++){
//             for(int j=0; j<rows; j++){
//                 grid[0][i] = Math.max(grid[j][i],grid[0][i]);
//             }
//         }
//         int sum = 0;
//         for(int i=0;i<cols; i++){
//             sum += grid[0][i];
//         }
//         return sum;
//     }
// }


class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        List<PriorityQueue<Integer>> list = new ArrayList<>();

        

        for(int[] row : grid){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int val : row){
                pq.add(val);
            }
            list.add(pq);
        }
        int sum = 0;
        for(int j=0; j<cols; j++){
            int max = -1;
            for(int i=0; i<rows; i++){
                max = Math.max(list.get(i).remove(),max);
            }
            sum += max;
        }
        return sum;
    }
}