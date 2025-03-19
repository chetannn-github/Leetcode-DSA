class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->(
            a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        )); 
        HashSet<Integer> hs = new HashSet<>(); 

        for (int i = 0; i < n; i++) {
            pq.add(new int[]{nums[i], i});  
        }

        long score = 0;
        while (!pq.isEmpty()) {
            int[] min = pq.remove();
            int minVal = min[0];
            int idx = min[1];

            if (hs.contains(idx)) continue;

            score += minVal;
            hs.add(idx);

            if(idx > 0) hs.add(idx - 1);
            if(idx < n-1) hs.add(idx + 1);
        }

        return score;
    }
}
