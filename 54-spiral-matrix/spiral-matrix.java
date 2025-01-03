class Solution {
    public List<Integer> spiralOrder(int[][] grid) {
        int top = 0, left = 0, right = grid[0].length-1, bottom = grid.length-1;
        List<Integer> ans = new ArrayList<>();

        while(top<=bottom && left<=right){

            for(int i = left; i<=right; i++){
                ans.add(grid[top][i]);
            }
            top++;

            for(int j = top; j<=bottom; j++){
                ans.add(grid[j][right]) ;
            }
            right--;
            
            if(top<=bottom){
                for(int p = right ; p>=left; p--){
                    ans.add(grid[bottom][p]);
                }
                bottom--;
            }
            if(left<=right){
                for(int l = bottom ; l>=top; l--){
                    ans.add(grid[l][left]);
                }
                left++;
            }
            
        }
        

    

        return ans;
    }
}