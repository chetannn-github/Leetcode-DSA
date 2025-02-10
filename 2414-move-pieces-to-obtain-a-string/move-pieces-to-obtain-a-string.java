
  // iss question me hume yhh move nhii krna hh bus dekhna hh kii possible hain yaa nhii
    class Solution{
        public boolean canChange(String s, String target) {
            int n=target.length();
            int i=0,j=0;
            while(i<=n && j<=n){
            
                while(i<n && target.charAt(i)=='_') i++;
                while(j<n && s.charAt(j)=='_') j++;
            
                if(i==n || j==n){
                    return i==n && j==n;
                }
            
                if(target.charAt(i)!=s.charAt(j)) return false;
            
                if(target.charAt(i)=='L'){
                    if(j<i) return false;
                }
                else{
                    if(i<j) return false;
                }
            
                i++;
                j++;
            }
            return true;
        }
    }
    
	