class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int num : nums){
            pq.add((long) num);
        }

        int count = 0;
        while(pq.peek() < k){
            long x = pq.remove();
            long y = pq.remove();
            pq.add(Math.min(x,y)*2 + Math.max(x,y));

            count++;
        }

        return count;
        
    }
}