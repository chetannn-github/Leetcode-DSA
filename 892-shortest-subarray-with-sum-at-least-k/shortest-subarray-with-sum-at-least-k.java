class Solution {
    public int shortestSubarray(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->((int)(a.prefixSum - b.prefixSum)));
        int n = nums.length;
        long totalSum = 0;
        int minLength = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            totalSum += nums[i];
            if(totalSum >= k) minLength = Math.min(minLength, i +1);

            while(!pq.isEmpty() && totalSum - pq.peek().prefixSum >= k) {
                minLength = Math.min(minLength, i - pq.remove().idx);
            }
            
            pq.add(new Pair(totalSum,i));
        }

        return  minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}


class Pair {
    long prefixSum;
    int idx;
    Pair(long prefixSum, int idx) {
        this.prefixSum = prefixSum;
        this.idx = idx;
    }
}