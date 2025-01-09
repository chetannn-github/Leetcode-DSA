class Solution {
    public int[] findBall(int[][] grid) {
        int[] balls = new int[grid[0].length];
        for(int i=0; i<balls.length; i++){
            balls[i] = getBallPosition(i,grid);
        }
        return balls;
    }

    public int getBallPosition(int ball,int[][] grid){
        
        int col = ball;
        for(int i=0; i<grid.length; i++){
            if(col == 0 && grid[i][0] == -1){
                return -1;
            }else if(col == grid[0].length-1 && grid[i][grid[0].length-1] == 1){
                return -1;
            } 
            else if(col!= grid[0].length-1 && grid[i][col]==1 && grid[i][col+1]== 1 ){
                col++;
            }else if(col!= grid[0].length-1 && grid[i][col]==1 && grid[i][col+1]== -1 ){
                return -1;
            }else if(col!= 0 && grid[i][col]==-1 && grid[i][col-1]== -1 ){
                col--;
            }else if(col!= 0 && grid[i][col]==-1 && grid[i][col-1]== 1 ){
                return -1;
            }
        }

        return col;

    }

    
}