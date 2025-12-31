class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        if(t.length() > n ) return "";

        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch : t.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int minWindowSize = Integer.MAX_VALUE;
        int minWindowStart = -1;
        int required = t.length();
        int start = 0;
        

        for(int end=0; end<n; end++) {
            char ch = s.charAt(end);
            map.put(ch,map.getOrDefault(ch,0) - 1);

            if(map.get(ch) >= 0) required--;

            while(required == 0) {
                if(end - start + 1 < minWindowSize) {
                    minWindowStart = start;
                    minWindowSize = end - start + 1;
                }

                char startChar = s.charAt(start++);
                map.put(startChar, map.get(startChar)+1);

                if(map.get(startChar) > 0) required++;
            }

        }

        return (minWindowSize == Integer.MAX_VALUE ? "" : s.substring(minWindowStart,minWindowStart + minWindowSize));
    }
}