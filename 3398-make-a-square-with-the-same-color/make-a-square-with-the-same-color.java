class Solution {
    public boolean canMakeSquare(char[][] grid) {
        int count = 0;
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                if(grid[i][j]=='B'){
                    count--;
                }else{
                    count++;
                }
                
            }
        }if(Math.abs(count)>=2){return true;}
        count = 0;
        for(int i=1; i<3; i++){
            for(int j=0; j<2; j++){
                if(grid[i][j]=='B'){
                    count--;
                }else{
                    count++;
                }
                
            }
        }if(Math.abs(count)>=2){return true;}
        count = 0;
        for(int i=0; i<2; i++){
            for(int j=1; j<3; j++){
                if(grid[i][j]=='B'){
                    count--;
                }else{
                    count++;
                }
                
            }
        }if(Math.abs(count)>=2){return true;}
        count = 0;
        for(int i=1; i<3; i++){
            for(int j=1; j<3; j++){
                if(grid[i][j]=='B'){
                    count--;
                }else{
                    count++;
                }
                
            }
        }if(Math.abs(count)>=2){return true;}
        return false;
    }
    
}