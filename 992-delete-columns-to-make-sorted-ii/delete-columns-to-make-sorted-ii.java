class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        int result = 0;
        boolean[] fulfilled = new boolean[rows-1];

        for(int col=0; col<cols; col++) {
            boolean isDeleted = false;
            for(int row=1; row<rows; row++) {
                if(!fulfilled[row-1] && strs[row-1].charAt(col) > strs[row].charAt(col)) {
                    result++;
                    isDeleted = true;
                    break;
                }
            }
            if(isDeleted) continue;

            for(int row=1; row<rows; row++) {
                if(strs[row-1].charAt(col) != strs[row].charAt(col)) {
                    fulfilled[row-1] = true;
                }
            }





        }

        return result;
    }
}