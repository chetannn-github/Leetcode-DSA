class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // sabse phele mujhe saare element ko hashmap  me daal du 
        //  with key as element and value as frequency
        HashMap<Integer,Integer> hm  = new HashMap<>();
        for(int num : nums){
             hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (hm.get(a) - hm.get(b)));

        for(Integer key : hm.keySet()){
            pq.add(key);
            if(pq.size() > k) pq.remove();
        }
      
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.remove();
        }
       
        return result;
    }
}