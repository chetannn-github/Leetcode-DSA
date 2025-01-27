class Solution {
    int r;int c;
    int n;
    public boolean exist(char[][] grid, String word) {
        r = grid.length;
        c = grid[0].length;
        n = word.length();

        boolean found = false;
        for(int i=0; i<r;i++){
            for(int j=0; j<c; j++){
                found = found || solve(grid,i,j,0,word);
                if(found){return found;}
            }
        }

        return found;
    }

    public boolean solve(char[][] grid, int i, int j,int start,String word){
        if(start >= n){
            return true;
        }
        if(i<0 || i>=r || j<0 || j>=c ||  grid[i][j] !=word.charAt(start)){
            return false;
        }
        
        char temp = grid[i][j];
        boolean ans = false;
        // right
        grid[i][j] = '#';
        ans = ans ||  solve(grid,i,j+1,start+1,word);
        
        if(ans){return ans;}
        
        // left
        
        ans =ans ||  solve(grid,i,j-1,start+1,word);
        
        if(ans){return ans;}

        // down 
        
        ans = ans || solve(grid,i+1,j,start+1,word);
        
        if(ans){return ans;}

        // up
        ans =  ans || solve(grid,i-1,j,start+1,word);
        grid[i][j]= temp;
        
        
        return ans;
    }
}
   