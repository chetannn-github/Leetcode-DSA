class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num : arr){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int key : hm.keySet()){
            int val = hm.get(key);
            if(hs.contains(val)) return false;
            hs.add(val);
        }

        return true;
    }
}