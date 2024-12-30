class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans = 0;
        for(int sec : time){
            sec %= 60;
            if(hm.containsKey((60-sec)%60)){
                ans += hm.get((60-sec)%60);
            }
            hm.put(sec, hm.getOrDefault(sec,0)+1);
        }
        return ans;
    }
}