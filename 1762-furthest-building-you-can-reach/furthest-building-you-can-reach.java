class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        int n = heights.length;
        int sum = 0;

        for(int i=1; i<n; i++){
            int diff = heights[i] - heights[i-1];
            if(diff > 0) {
                pq.add(diff);
                sum += diff;

                if(sum > bricks) {
                    if(ladders > 0) {
                        int maxDiff = pq.remove();
                        sum -= maxDiff;
                        ladders--;
                    }else {
                        return i-1;
                    }
                }
            }
            
        }

        return n-1;
    }
}