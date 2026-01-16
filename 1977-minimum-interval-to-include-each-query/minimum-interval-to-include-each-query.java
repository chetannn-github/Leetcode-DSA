class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[][] modQueries = new int[n][2];

        for(int i=0; i<n; i++) {
            modQueries[i][0] = queries[i];
            modQueries[i][1] = i;
        }

        Arrays.sort(intervals,(a,b)->(
            a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        ));
        Arrays.sort(modQueries,(a,b)->(a[0]-b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> (
            (intervals[a][1] - intervals[a][0] + 1) - (intervals[b][1] - intervals[b][0] + 1))
        );
        
        int intervalIdx = 0;
        int k = intervals.length;
        int[] result = new int[n];

        for(int i=0; i<n; i++) {
            int q = modQueries[i][0];
            int idx = modQueries[i][1];

            while(intervalIdx < k && intervals[intervalIdx][0] <= q ) {
                pq.add(intervalIdx++);
            } 
            while(!pq.isEmpty() && intervals[pq.peek()][1] < q) pq.remove();

            result[idx] = pq.isEmpty() ? -1 : intervals[pq.peek()][1] - intervals[pq.peek()][0] + 1;
        }

        return result;
    }
}

