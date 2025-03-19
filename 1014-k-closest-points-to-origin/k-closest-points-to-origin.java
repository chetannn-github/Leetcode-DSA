class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(
            (Math.sqrt(Math.pow(a[0],2) + Math.pow(a[1],2)) - Math.sqrt(Math.pow(b[0],2) + Math.pow(b[1],2))) >0 ? 1 : -1
        ));

        for(int[] row : points){
            pq.add(row);
        }
        int[][] ans = new int[k][2];
        int idx = 0;
        while(idx != k){
            ans[idx++] = pq.remove();
        }

        return ans;

    }
}