class Solution {
    public long countPairs(String[] words) {
        HashMap<String,Long> map = new HashMap<>();
        for(String word : words) {
        
            String normalised = normalise(word);
            map.put(normalised, map.getOrDefault(normalised,0L)+1);
        }
        long result = 0L;
        for(String key : map.keySet()) {
            long val = map.get(key);
            result = result + (val * (val-1)/2);
        }

        return result;
    }

    String normalise(String w) {
        int base = w.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder();
    
        for (int i = 0; i < w.length(); i++) {
            int diff = (w.charAt(i) - 'a' - base + 26) % 26;
            sb.append(diff).append('#');
        }
        return sb.toString();
    }

}


