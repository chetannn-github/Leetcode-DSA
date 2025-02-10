class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int[] prefix  = new int[words.length+1];
        prefix[0] = 0;
        int idx = 1;
        for(String word : words){
            if(checkVowelString(word,vowels)){
                prefix[idx] = prefix[idx-1] + 1;
            }else{
                prefix[idx] = prefix[idx-1];
            }
            idx++;
        }
        int ans[] = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            ans[i] = prefix[queries[i][1]+1] - prefix[queries[i][0]];

        }
        return ans;


    }

    public boolean checkVowelString(String word, Set vowels){
        return vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length()-1));
    }
}