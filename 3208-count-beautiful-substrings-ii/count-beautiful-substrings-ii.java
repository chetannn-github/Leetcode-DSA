class Solution {
    public long beautifulSubstrings(String s, int k) {
        int n = s.length();
        int totalVowelCount = 0;
        int diff = 0;
        long count = 0L;
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        map.put(0, new HashMap<>());
        map.get(0).put(0,1);

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            totalVowelCount += (isVowel(ch) ? 1 : 0);
            diff += (isVowel(ch) ? 1 : -1);

            HashMap<Integer,Integer> currDiffMap = map.getOrDefault(diff, new HashMap<>());

            for(int key : currDiffMap.keySet()) {
                int freq = currDiffMap.get(key);
                int currSubArrayVowelCount = (totalVowelCount %k - key);
                if((currSubArrayVowelCount * currSubArrayVowelCount) % k == 0 ) {
                    count += freq;
                }
            }


            currDiffMap.put(totalVowelCount%k,currDiffMap.getOrDefault(totalVowelCount%k,0) + 1);
            map.put(diff,currDiffMap);
        }  

        

        return count;
    }


    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}