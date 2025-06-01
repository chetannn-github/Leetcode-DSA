class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        
        int count = 0;
        for(int val1 : arr1) {
            boolean isAllFalse = true;
            for(int val2 : arr2) {
                if(Math.abs(val1 - val2) <= d) {
                    isAllFalse = false;
                    break;
                }
            }

            if(isAllFalse) count++;
        }
        return count;
    }
}