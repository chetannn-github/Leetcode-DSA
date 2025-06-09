class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int l1 = word1.length();
        int l2 = word2.length();
        for(int i=0, j=0; (i<l1 || j<l2) ;  ){
            if(i>=word1.length()){
                ans.append(word2.charAt(j));
                j++;
            }else if( j>=word2.length()){ 
                ans.append(word1.charAt(i));
                i++;
            }else if(word1.charAt(i)==word2.charAt(j)){ 
                // twist yhii hh same aajae toh kisse aage badhaye i aur j 
                // it depends aage kon bada character dega
                
                ans.append(word1.charAt(i));
                int k = i+1;
                int q = j+1;
                while(true){
                    if(k<l1 && q<l2 && word1.charAt(k)==word2.charAt(q)){
                        k++;
                        q++;
                    }else if(k>=l1 ){
                        j++;
                        break;
                    }else if( q>=l2){
                        i++;
                        break;
                    }else if(word1.charAt(k)>word2.charAt(q)){
                        i++;
                        break;
                    }else{
                        j++;
                        break;
                    }
                }
            }else if(word1.charAt(i)<word2.charAt(j)){
                ans.append(word2.charAt(j));
                j++;
            }else if(word1.charAt(i)>word2.charAt(j)){ 
                ans.append(word1.charAt(i));
                i++;
            }

        }
       return ans.toString();
    }
}