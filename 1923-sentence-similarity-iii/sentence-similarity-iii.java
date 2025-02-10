class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // aage se check kro 
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        int l1 = s1.length;
        int l2 = s2.length;

        int i = 0;
        int j = Math.max(l1,l2)-1;
        
        int p = 0;
        int q = Math.min(l1,l2)-1;

        if(l1>=l2){
            while(p<l2){
                if(s1[i].equals(s2[p]) ){
                    i++;
                    p++;
                }else{
                    break;
                }
            }
            // System.out.println("p---->"+p);
            while(q>=p){
                if(s1[j].equals(s2[q])){
                    j--;
                    q--;
                }else{
                    break;
                }
            }
        }else{
            while(p<l1){
                if(s2[i].equals(s1[p]) ){
                    i++;
                    p++;
                }else{
                    break;
                }
            }

            while(q>=p){
                if(s2[j].equals(s1[q])){
                    j--;
                    q--;
                }else{
                    break;
                }
            }
        }


        if((p-q)!=1){
            // System.out.println(q);
            return false;
        }

        return true;
        
    }
}