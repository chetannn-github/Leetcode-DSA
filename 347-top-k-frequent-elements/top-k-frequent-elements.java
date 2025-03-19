class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // sabse phele mujhe saare element ko hashmap  me daal du 
        //  with key as element and value as frequency
        HashMap<Integer,Integer> hm  = new HashMap<>();
        for(int num : nums){
             hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        ArrayList<int[]> list = new ArrayList<>();

        for(Integer key : hm.keySet()){
            list.add(new int[] {key,hm.get(key)});
        }
        
        Collections.sort(list,(a,b)->(b[1]-a[1]));
      
        int[] array = new int[k];
        for (int i = 0; i < k; i++) {
            array[i] = list.get(i)[0];
        }
       
        return array;
    }
}