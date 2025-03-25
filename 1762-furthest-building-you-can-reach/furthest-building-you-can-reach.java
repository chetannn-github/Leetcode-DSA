class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = heights.length;
        int leftBricks = bricks;
        

        for(int i=1; i<n; i++){
            if(heights[i] > heights[i-1]){
                pq.add(heights[i] - heights[i-1]);
                // System.out.println(pq.toString());

                if(pq.size() > ladders){
                    leftBricks -= pq.remove();
                }

                if(leftBricks < 0){
                    return i-1;
                }
            }
            
        }

        return n-1;
    }
}