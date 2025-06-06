class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int ans = 0;
        int opening = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ')') {
                if(opening == 0){
                // check phr next char bhii ')' hain yaa nhii
                    if(i+1 < n && s.charAt(i+1)==')'){
                        ans++;
                        i++;
                    }else{
                        ans += 2;
                    }
                }else {
                    if(i+1< n && s.charAt(i+1)==')'){
                        i++;
                    }else{
                        ans++;
                    }
                    opening--;
                }
            }else {
               opening++;
            }
        }
        
        return ans + opening *2;
    }
}