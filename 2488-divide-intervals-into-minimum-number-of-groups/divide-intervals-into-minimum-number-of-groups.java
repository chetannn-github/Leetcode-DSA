class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        int n = intervals.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(0);
        int groups = 1;


        for(int[] interval : intervals) {
            int minEnd = pq.peek();

            int start = interval[0];
            int end = interval[1];

            if(minEnd < start) {
                pq.remove();
            }else {
                groups++;
            }
            pq.add(end);

        }
        
        return groups;
    }
}