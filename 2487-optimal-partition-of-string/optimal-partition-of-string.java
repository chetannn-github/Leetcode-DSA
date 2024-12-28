class Solution {
    public int partitionString(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(hm.getOrDefault(ch,0)!=0){
                count++;
                hm.clear();
            }
            hm.put(ch,1);
        }

        return count+1;
    }
}