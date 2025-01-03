class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;
        List<List<Integer>> ans  = new ArrayList<>();
        int last = -1 ;
        int currRowLast = -2;
        k %= (r*c);

        while(k>0){
           for(int i=0; i<r; i++){
            currRowLast = grid[i][c-1];
                
            for(int j=c-1; j>=0; j--){
                if(i==0 && j==0){
                    if(r==1 ){
                        grid[0][0] = currRowLast;
                    }else{
                        grid[0][0] = grid[r-1][c-1];
                    }
                    
                }else if(i!=0 && j==0){
                   grid[i][0]= last;
                   
                }else{
                   grid[i][j] =  grid[i][j-1];
                }
            }
            last = currRowLast;
            } 
            k--;
        }

        for(int i=0; i<r; i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<c; j++){
                row.add(grid[i][j]);
            }
            ans.add(row);
        }

        
        
        return ans;
    }
    
}