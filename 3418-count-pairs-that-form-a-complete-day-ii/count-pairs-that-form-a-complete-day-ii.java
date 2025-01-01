class Solution {
    public long countCompleteDayPairs(int[] hours) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        long count = 0; 

        for(int hr : hours){
            hr = hr%24;
            count += hm.getOrDefault((24-hr)%24,0);

            hm.put(hr,hm.getOrDefault(hr,0)+1);
        }

        return count; 
    }
}