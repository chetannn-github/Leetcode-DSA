class Solution {
    public int findTheLongestSubstring(String s) {
        int result = 0;
        int mask = 0;
        HashMap<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);  // base case

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(isVowel(ch)) {
                mask ^= (1 << (ch-'a'));
            }
            
            if (seen.containsKey(mask)) {
                result = Math.max(result, i - seen.get(mask));
            } else {
                seen.put(mask, i);
            }

        }

        return result;
    }


    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}