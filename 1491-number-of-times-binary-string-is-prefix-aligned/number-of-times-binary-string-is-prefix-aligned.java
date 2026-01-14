class Solution {
    public int numTimesAllBlue(int[] flips) {
        long currSum = 0L;
        long sumNeeded = 0L;
        int n = flips.length;
        int result = 0;

        for(int i=0; i<n; i++) {
            currSum += flips[i];
            if(i % 2 == 0) {
                sumNeeded = ((i+2)/2) * (i+1);
            }else sumNeeded = ((i+1)/2) * (i+2);
            
            if(currSum == sumNeeded) result++;
        }

        return result;
    }
}