class Solution {
    public int[][] resultGrid(int[][] image, int threshold) {
        int rows = image.length;
        int cols = image[0].length;
        int[][] result = new int[rows][cols];
        int[][] count = new int[rows][cols];
        

        for(int i=0; i<rows-2;i++){
            for(int j=0;j<cols-2; j++){
                boolean isValid = checkValidgrid(i,j,threshold,image);
                if(isValid){
                    int avg = calcAvgGrid(i,j,image);
                    for(int p = i; p<i+3; p++){
                        for(int q = j; q<j+3; q++){
                            result[p][q] += avg;
                            count[p][q]++; 
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (count[i][j] > 0) {
                    result[i][j] /= count[i][j]; 
                } else {
                    result[i][j] = image[i][j];
                }
            }
        }

        return result;
    }

    public boolean checkValidgrid(int r1,int c1,int th ,int[][] image){
        
        // row checking 

        for(int i=r1; i<r1+3; i++){
            for(int j=c1; j<c1+2; j++){
                if(Math.abs(image[i][j]- image[i][j+1])>th ){
                    return false;
                }
            }
        }
        

        // col checking
        for(int i=r1; i<r1+2; i++){
            for(int j=c1; j<c1+3; j++){
                if(Math.abs(image[i][j]- image[i+1][j])>th ){
                    return false;
                }
            }
        }
        return true;
    }

    public int calcAvgGrid(int r1, int c1, int[][] image){
        int sum = 0;
        for(int i=r1; i<r1+3; i++){
            for(int j= c1; j<c1+3; j++){
                sum += image[i][j];
            }
        }
        return sum/9;
    }
}