class Solution {
    public int minSetSize(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;

        for(int num : nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));

        for(int key : hm.keySet()){
            pq.add(hm.get(key));
        }
        int halfSize = n/2;
        int count = 0;
        while(n>halfSize){
            n -= pq.remove();
            count++;
        }
        return count;
    }
}