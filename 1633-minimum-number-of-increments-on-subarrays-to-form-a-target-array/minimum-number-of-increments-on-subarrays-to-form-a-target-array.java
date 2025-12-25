class Solution {
    public int minNumberOperations(int[] target) {
        int ops = 0;
        int prev = 0;
        int n = target.length;
        
        for(int i=0; i<n; i++) {

            if(target[i] > prev) {
                ops += target[i] - prev;
            }

            prev = target[i];
        }

        return ops;
    }
}