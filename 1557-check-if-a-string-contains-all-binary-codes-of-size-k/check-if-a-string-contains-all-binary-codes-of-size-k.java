// class Solution {
//     public boolean hasAllCodes(String s, int k) {
//         int n = s.length();

//         HashSet<StringBuilder> hs = new HashSet<>();
//         StringBuilder sb = new StringBuilder();
        
//         for(int i=0; i<k; i++) {
//             sb.append(s.charAt(i));
//         }
        
//         hs.add(new StringBuilder(sb));

//         if(hs.size() == Math.pow(2,k)) {
//             return true;
//         } 
        
//         for(int i=k; i<n; i++) {
//             sb.deleteCharAt(0);
//             sb.append(s.charAt(i));
//             hs.add(new StringBuilder(sb));

//             if(hs.size() == (1<<k)) {
//                 return true;
//             } 
//         }
//         return false;
//     }
// } 
    

class Solution {
    char[] code;
    int k;
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if(n<k) return false;
        this.k = k;

        HashSet<String> hs = new HashSet<>();
        code = new char[k];
        
        for(int i=0; i<k; i++) {
            code[i] = s.charAt(i);
        }
        
        hs.add(new String(code));

        if(hs.size() == (1<<k)) {
            return true;
        } 
        
        for(int i=k; i<n; i++) {
            // add curr and delete first char
            updateCodeArray(s.charAt(i));
            hs.add(new String(code));

            if(hs.size() == (1<<k)) {
                return true;
            } 
        }
        return false;
    }

    public void updateCodeArray(char ch) {
        for(int i = 0; i<k-1; i++) {
            code[i] = code[i+1];
        }
        code[k-1] = ch;
    }
} 
    
