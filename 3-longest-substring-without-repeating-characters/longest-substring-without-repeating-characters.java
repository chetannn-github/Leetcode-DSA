// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if(s.length()==0){
//             return 0;
//         }
//         int start = 0;
//         int length = 1;
//         HashMap<Character,Integer> hm = new HashMap<>();
        
//         for(int end = 0; end<s.length();end++){
//             char ch = s.charAt(end);
            
//             if(hm.isEmpty()  || !hm.containsKey(ch) || hm.get(ch)<start) {
//                 length = Math.max(length, end - start +1);

//             }else if(hm.containsKey(ch)){
//                 start = hm.get(ch)+1;
//             }
//             hm.put(ch,end);
//         }
//         return length ;
//     }
// }

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int start = 0;
        int length = 1;
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(int end = 0; end<s.length();end++){
            char ch = s.charAt(end);
            
            while (hm.getOrDefault(ch,0) > 0) {
                char st = s.charAt(start);
                hm.put(st,hm.getOrDefault(st,0)-1);
                start++;
            }
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            length = Math.max(length,end-start+1);
        }
        return length ;
    }
}
