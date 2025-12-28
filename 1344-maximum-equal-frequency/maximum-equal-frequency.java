class Solution {
    public int maxEqualFreq(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        int result = 0;

        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            int prevFreq = map.getOrDefault(num,0);

            if(prevFreq != 0) {
                freqMap.put(prevFreq,freqMap.get(prevFreq)-1);
                if(freqMap.get(prevFreq) == 0) freqMap.remove(prevFreq);
            }

            map.put(num,prevFreq+1);
            freqMap.put(prevFreq+1,freqMap.getOrDefault(prevFreq+1,0) + 1);

            if(freqMap.size() == 2) {
                if(freqMap.getOrDefault(1,-1) == 1) {
                    result = i + 1;
                    continue;
                }

                int key1 = -1;
                int key2 = -1;
                for(int key : freqMap.keySet()) {
                    if(key1 == -1) key1 = key;
                    else key2 = key;
                }

                int maxKey = Math.max(key1,key2);
                int minKey = Math.min(key1,key2);

                if(maxKey - minKey == 1 && freqMap.get(maxKey) == 1) {
                    result = i+1;
                    continue;
                }
            }

            if(freqMap.size() == 1 ) {
                if(freqMap.containsKey(1)) {
                    result = i + 1;
                    continue;
                }

                for(int key : freqMap.keySet()) {
                    if(freqMap.get(key) == 1) result = i+1;
                }
            }
        }
        return result;        
    }
}