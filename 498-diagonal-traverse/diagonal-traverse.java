class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length; 
        int cols = mat[0].length;
        int[] ans = new int[rows*cols];
        int x =0, y=0;
        int count = 0;
        int dirX = 1, dirY = -1;
        

        while(count<ans.length ){
            //down to up
            dirX = -1;dirY = 1;
            while(count<ans.length && x >= 0 && x < rows && y>= 0 && y < cols){
                ans[count] = mat[x][y];
                count++;
                x += dirX;
                y += dirY;
            }
            
            x -= dirX;
            y -= dirY;
            if(y<=cols-2){
                y++;
            }else{
                x++;
            }
            // up to down
            dirX = 1;dirY = -1;
            while(count<ans.length &&x >= 0 && x < rows && y>= 0 && y < cols){
                ans[count] = mat[x][y];
                count++;
                x += dirX;
                y += dirY; 
            }
           
            x -= dirX;
            y -= dirY;
            if(x<=rows-2){
                x++;
            }else{
                y++;
            }
            

        }

        return ans;

    }
}