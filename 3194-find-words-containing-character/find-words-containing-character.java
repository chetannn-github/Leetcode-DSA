class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        int idx = 0;
        for(String word : words) {
            for(char ch : word.toCharArray()) {
                if(ch == x){ 
                    result.add(idx);
                    break;
                }
            }
            idx++;
        }


        return result;

    }
}