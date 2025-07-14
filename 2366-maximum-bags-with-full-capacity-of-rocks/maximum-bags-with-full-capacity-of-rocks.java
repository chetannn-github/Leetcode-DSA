class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int fullCapacityBags = 0;
        
        for(int i=0; i<n; i++) {
            capacity[i] -= rocks[i];
        }

        Arrays.sort(capacity);
        int idx = 0;
        while(idx < n) {

            if(capacity[idx] > additionalRocks) {
                return fullCapacityBags;
            }else {
                additionalRocks -= capacity[idx] ;
                fullCapacityBags++;
            }
            idx++;
        }

        return fullCapacityBags;
    }
}