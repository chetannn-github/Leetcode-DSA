class Solution {
    public boolean hasAllCodes(String s, int k) {
        int length = s.length();
        if(length<k) return false;

        HashSet<String> hs = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<k; i++){
            sb.append(s.charAt(i));
        }
        
        hs.add(sb.toString());

        if(hs.size() == Math.pow(2,k)){
            return true;
        } 

        for(int i=k; i<length;i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            hs.add(sb.toString());

            if(hs.size() == Math.pow(2,k)){
                return true;
            } 
        }
        return false;
    }
} 
    
