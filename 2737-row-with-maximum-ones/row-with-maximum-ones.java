class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int max[] = new int[2];
        for(int i=0; i<mat.length; i++){
            int count =0;
            for(int j=0; j<mat[0].length; j++){
                count += mat[i][j];
            }
            if(max[1]< count){
                max[1] = count; 
                max[0] = i;
            }

            // if saare one toh nhii h
            if(count==mat[0].length){ break;}

        }
        return max;
    }
}