class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if (s1.length < s2.length) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        
        int i = 0;
        int j = s2.length - 1;

        int m = 0;
        int n = s1.length - 1;

        while (i <= j && s1[m].equals(s2[i])) {
            i++;
            m++;
        }

        while (j >= i && s1[n].equals(s2[j])) {
            j--;
            n--;
        }

        return i > j;
    }
}
