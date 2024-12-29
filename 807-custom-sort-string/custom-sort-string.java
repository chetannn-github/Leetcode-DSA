class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch,0)+1);
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<order.length(); i++){
            char ch = order.charAt(i);
            int freq = hm.getOrDefault(ch,0);

            if(freq !=0){
                hm.remove(ch);
                for(int k=0; k<freq; k++){
                    sb.append(ch);
                }
            }
        }

        for(Character ch : hm.keySet()){
            int freq = hm.getOrDefault(ch,0);

            if(freq !=0){
                for(int k=0; k<freq; k++){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}