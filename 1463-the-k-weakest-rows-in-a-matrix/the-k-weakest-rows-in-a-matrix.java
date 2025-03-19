class Solution {
    public int[] kWeakestRows(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] ans = new int[k];

        int[] freq = new int[rows];

        for(int i=0; i<rows; i++){
            int count = 0;
            for(int j=0; j<cols;j++){
                if(grid[i][j]==1){
                    count++;
                }else{
                    break;
                }
            }
            freq[i] = count;
        } 

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (
            freq[a] == freq[b] ? a -b : freq[a] - freq[b]
        ));

        for(int i=0; i<rows; i++){
            pq.add(i);
        }

        for(int i=0; i<k; i++){
            ans[i] = pq.remove();
        }
        return ans;
    }
}