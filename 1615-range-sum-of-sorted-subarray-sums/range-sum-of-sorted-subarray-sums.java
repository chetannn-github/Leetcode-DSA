class Solution {
    int MOD = 1_000_000_007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b)-> (b-a > 0 ? 1 : -1));
        for(int i=0; i<n; i++) {
            long sum = 0;

            for(int j = i; j< n; j++) {
                sum += nums[j];

                pq.add(sum);
                if(pq.size() > right) {
                    pq.remove();
                }
            }
        }
        long result = 0;
        while(pq.size() >= left) {
            result += (pq.remove());
        }

        return (int) (result  % MOD);
    }
}