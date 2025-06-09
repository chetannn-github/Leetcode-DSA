class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int start = 0;
        int end = n-1;
        if(n<=1){
            return n;
        }

        while(start<end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;

                while(start<n && s.charAt(start-1) == s.charAt(start)){
                    start++;
                }
                
                while(end>=0 && s.charAt(end+1) == s.charAt(end)){
                   end--;
                }
                
            }else{ 
                return end - start +1;
            }
        }
        return start == end ? 1 :  0; 
    }
}