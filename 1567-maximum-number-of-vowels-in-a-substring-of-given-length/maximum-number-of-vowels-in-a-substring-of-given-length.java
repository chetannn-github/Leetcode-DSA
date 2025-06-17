class Solution {
    public int maxVowels(String s, int k) {
        int length = s.length();
        int ans = 0;

        for(int i=0; i<k; i++){
            ans = isVowel(s.charAt(i))? ans+1 : ans;
        }

        if(ans==k) return ans;
        int temp = ans;

        for(int i=k; i<length;i++){
            temp = isVowel(s.charAt(i-k)) ?  temp - 1 : temp ;
            temp = isVowel(s.charAt(i)) ?  temp + 1 : temp ;

            ans = Math.max(temp,ans);
            if (ans==k) return ans;
        }
        return ans;
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}