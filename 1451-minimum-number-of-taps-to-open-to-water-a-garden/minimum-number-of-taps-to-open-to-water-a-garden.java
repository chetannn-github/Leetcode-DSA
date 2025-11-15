class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] startEnd = new int[n+1];

        for(int i=0; i<=n; i++) {
            int start = Math.max(0, i-ranges[i]);
            int end = Math.min(n, i+ranges[i]);
            startEnd[start] = Math.max(end, startEnd[start]);
        }

        int currEnd = 0;
        int maxEnd = 0; 
        int taps = 0;

        for(int i=0; i<=n; i++) {
            if(i > maxEnd) return -1;
            if(i > currEnd) {
                currEnd = maxEnd;
                taps++;
            }

            maxEnd = Math.max(maxEnd, startEnd[i]);
        }

        return taps;
    } 
}