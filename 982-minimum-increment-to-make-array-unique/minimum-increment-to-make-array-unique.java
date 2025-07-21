class Solution {
    public int minIncrementForUnique(int[] nums) {
        int[] freq = new int[1000001];

        for(int num : nums) freq[num]++;

        int ops = 0;

        for(int i=0; i<freq.length; i++) {

            if(freq[i] > 1) {
                ops += freq[i] - 1;
                
                if(i<freq.length-1) {
                    freq[i+1] += freq[i] - 1;
                }
            }
            
        }

        return ops;
    }
}