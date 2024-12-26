class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(ch>='a' && ch<='z'){
                hm.put(ch,i);
            }
        }
        int ans = 0;
        for(int i= 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(ch>='A' && ch<='Z'){
                ch = Character.toLowerCase(ch);
                if(hm.containsKey(ch) ){
                    if(hm.get(ch)<i){
                        ans++;
                    }
                hm.remove(ch);
                }
            }
            
        }

        return ans;
    }
}