class Solution {
    public double maxAverageRatio(int[][] classes, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double gainA = ((double) (a[0] + 1) / (a[1] + 1)) - ((double) a[0] / a[1]);
            double gainB = ((double) (b[0] + 1) / (b[1] + 1)) - ((double) b[0] / b[1]);
            return Double.compare(gainB, gainA);
        });
        double avg = 0.0;

        for(int[] c : classes) {
            pq.add(new int[]{c[0],c[1]});
            avg += ((double) c[0]/c[1]);
        }

        while(k!=0) {
            int[] c = pq.remove();
            avg -= ((double) c[0]/c[1]);
            c[0] += 1;
            c[1] += 1;

            avg += ((double) c[0]/c[1]);
            pq.add(c);
            k--;
        }

        return (double) avg/classes.length;  
    }
}