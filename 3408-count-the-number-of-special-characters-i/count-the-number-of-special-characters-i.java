class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> hs = new HashSet<>();
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(ch>='a' && ch<='z'){
                hs.add(Character.toUpperCase(ch));
            }
        }
        int ans = 0;
        for(int i= 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(hs.contains(ch)){
                ans++;
                hs.remove(ch);
            }
        }

        return ans;
    }
}