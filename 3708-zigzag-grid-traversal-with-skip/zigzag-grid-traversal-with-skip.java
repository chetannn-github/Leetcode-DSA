class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> ans = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int col = 0;
        boolean LeftToRight = true;

        for(int i=0; i<rows; i++){
            
            while((LeftToRight&&col<cols) || (!LeftToRight && col>=0)){
                ans.add(grid[i][col]);
                if(LeftToRight){col +=2;}
                else{col -= 2;}
            }

            if(LeftToRight){
                if(cols-1==col-2){
                    col = cols-2;
                }else{
                    col = cols -1;
                }
            }else{
                if(col ==-2){
                    col = 1;
                }else{
                    col = 0;
                }
            }
            
            LeftToRight = !LeftToRight;
        }

        return ans;
    }
}