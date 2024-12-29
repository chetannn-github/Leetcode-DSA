// class Solution {
//     public boolean canConvertString(String s, String t, int k) {
//         if(s.length()!= t.length()){
//             return false;
//         }
//         HashMap<Integer,Integer> hm = new HashMap<>();

//         for(int i=0; i<s.length(); i++){
//             if(s.charAt(i)!= t.charAt(i)){
//                 int dif =(int) (t.charAt(i) - s.charAt(i));

//                 if(dif<0){dif = (dif+26)%26;}
    
//                 if(dif>k){return false;}
//                 hm.put(dif, hm.getOrDefault(dif,0)+1);
//             }
//         }

//         for(int key : hm.keySet()){
//             int freq = hm.get(key);
//             if( (((freq-1)*26)+ key )>k){
//                 return false;
//             }
//         }
    
//         return true;
//     }
// }


class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if(s.length()!= t.length()){
            return false;
        }
    
        int[] map = new int[26];

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!= t.charAt(i)){
                int dif =(int) (t.charAt(i) - s.charAt(i));

                if(dif<0){dif = (dif+26)%26;}
    
                if(dif>k){return false;}
                
                map[dif]++;
            }
        }

        for(int i=1; i<26; i++){
            if( (((map[i]-1)*26)+ i )>k){
                return false;
            }
        }
    
        return true;
    }
}