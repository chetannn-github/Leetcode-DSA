class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch,0)+1);
        }
        int value = -1;
        for(Character key : hm.keySet()){
            if(value ==-1){
                value = hm.get(key);
            }else if(value != hm.get(key)){
                return false;
            }
        }
        return true;
    }

}