class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxFreq = 1;
        HashMap<Character,Integer> hm = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for(int end =0; end<n; end++){
            char ch = s.charAt(end);
            hm.put(ch, hm.getOrDefault(ch,0)+1);
            maxFreq = Math.max(maxFreq, hm.get(ch));

            while(end-start + 1 > k + maxFreq){
                char leftChar = s.charAt(start);
                hm.put(leftChar, hm.get(leftChar)-1);
                start++;
            
            }

            maxLength = Math.max(maxLength, end-start+1);
        }

        return maxLength;
    }
}