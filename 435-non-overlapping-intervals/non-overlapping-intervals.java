class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[1] - b[1]));
        int maxNonOverlapping = 0;
        int n = intervals.length;

        maxNonOverlapping++;
        int prevTime = intervals[0][1];

        for(int i=1; i<n; i++) {
            if(intervals[i][0] >= prevTime) {
                prevTime = intervals[i][1];
                maxNonOverlapping++;
            }
        }


        return n - maxNonOverlapping;
    }
}