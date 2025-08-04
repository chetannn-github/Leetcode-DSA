class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] freq = new int[26];
        int n = s.length();

        for(char ch : s.toCharArray()) {
            freq[ch-'a']++;
        }

        HashSet<Integer> addedChars = new HashSet<>();
        int prev = 0;

        for(int i=0; i<n; i++) {
            int ch = s.charAt(i) - 'a';
            addedChars.add(ch);

            if(--freq[ch] == 0) {
                addedChars.remove(ch);
            }

            if(addedChars.size()== 0) {
                result.add(i - prev + 1);
                prev = i+1;
            }
        }

        return result;
    }
}