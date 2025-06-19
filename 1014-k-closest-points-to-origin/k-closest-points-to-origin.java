class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(
            compareDistanceBtwPoints(b,a)
        ));

        for(int[] row : points){
            pq.add(row);
            if(pq.size() > k) pq.remove();
        }
        int[][] ans = new int[k][2];
        int idx = 0;
        while(idx != k){
            ans[idx++] = pq.remove();
        }

        return ans;

    }


    public int compareDistanceBtwPoints (int[] a, int[] b) {
        double distanceOne = Math.sqrt(Math.pow(a[0],2) + Math.pow(a[1],2));
        double distanceTwo = Math.sqrt(Math.pow(b[0],2) + Math.pow(b[1],2));
        return distanceOne - distanceTwo > 0 ? 1 : -1;
    }
}