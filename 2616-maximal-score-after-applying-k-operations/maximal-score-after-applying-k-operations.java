class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        long score = 0;
        for(int num : nums){
            pq.add(num);
        }

        while(k!=0){
            int max = pq.remove();
            score += max;
            if(max % 3 == 0) pq.add(max/3);
            else pq.add(max/3 +1);
            
            k--;
        }

        return score;
    }
}