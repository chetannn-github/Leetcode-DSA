class Solution {
    public int findLeastNumOfUniqueInts(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num : nums) hm.put(num, hm.getOrDefault(num,0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(hm.get(a) - hm.get(b)));

        for(int key : hm.keySet()) pq.add(key);
        int totalUnique = pq.size();

        while(k>0) {
            k -= hm.get(pq.remove());
            totalUnique--;
        }

        return k<0 ? totalUnique + 1 : totalUnique;
    }
}