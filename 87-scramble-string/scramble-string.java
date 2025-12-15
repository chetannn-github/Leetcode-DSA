class Solution {
    HashMap<String,Boolean> dp = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();    
        if(n==1) return s1.charAt(0) == s2.charAt(0);
        String key = s1 + "_" + s2;

        if(dp.containsKey(key)) return dp.get(key);

        boolean result = false;
        for(int i=0; i<n-1; i++) {
            boolean swap = (
                isScramble(s1.substring(0,i+1),s2.substring(n-i-1,n)) && 
                isScramble(s1.substring(i+1,n),s2.substring(0,n-i-1))
            );
            boolean not_swap = (
                isScramble(s1.substring(0,i+1),s2.substring(0,i+1)) && 
                isScramble(s1.substring(i+1,n),s2.substring(i+1,n))
            );

            result = swap || not_swap;
            if(result) break;
        }   
        dp.put(key,result);
        return result;
    }

    
}