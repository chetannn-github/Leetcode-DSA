class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(b.diff-a.diff));
        int result = Integer.MIN_VALUE;

        for(int[] point : points) {
            int x = point[0], y = point[1];

            while(!pq.isEmpty() && (x - pq.peek().x) > k) pq.remove();

            if(!pq.isEmpty()) {
                result = Math.max(result,pq.peek().diff + x + y);
            }

            pq.add(new Pair(x,y-x));

        }

        return result;
    }

}

class Pair{
    int x;
    int diff;
    Pair(int x, int diff) {
        this.x = x;
        this.diff = diff;
    }
}
