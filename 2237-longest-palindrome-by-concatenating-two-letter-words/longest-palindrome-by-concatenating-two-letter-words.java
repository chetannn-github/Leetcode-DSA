class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> freq = new HashMap<>();
        int eq = 0;
        int length = 0;

        for(String word : words) {
            char first = word.charAt(0);
            char second = word.charAt(1);
            String rev = second + "" + first;
            if(freq.containsKey(rev)) {
                freq.put(rev,freq.get(rev)-1);
                if(freq.get(rev) == 0) freq.remove(rev);
                length += 4;
            }else {
                freq.put(word , freq.getOrDefault(word,0) + 1);
            }
        }


        for(String key : freq.keySet()) {
            char first = key.charAt(0);
            char second = key.charAt(1);

            if(first == second) return length + 2;
        }

        return length;
    }
}