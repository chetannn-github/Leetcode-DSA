// class Solution {
//     public String reorganizeString(String s) {
//         HashMap<Character,Integer> freq = new HashMap<>();
        
//         for(char ch : s.toCharArray()) {
//             freq.put(ch, freq.getOrDefault(ch,0) + 1);
//         }
//         PriorityQueue<Character> pq = new PriorityQueue<>((a,b)-> (freq.get(b) - freq.get(a)));

//         for(char key : freq.keySet()) {
//             pq.add(key);
//         }

//         StringBuilder sb = new StringBuilder();
//         char prev = '$';

//         while(!pq.isEmpty()) {
//             char curr = pq.remove();
//             sb.append(curr);

//             if(prev != '$') pq.add(prev);

//             if(freq.get(curr) > 1) {
//                 freq.put(curr,freq.get(curr) - 1);
//                 prev = curr;
//             }
//             else {
//                 freq.remove(curr);
//                 prev = '$';
//             }
            
//         }

//         if(prev != sb.charAt(sb.length() - 1) && prev != '$') {
//             sb.append(prev);
//         }
       

//         return sb.length() == s.length() ? sb.toString() : "";

//     }
// }


class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> freq[b - 'a'] - freq[a - 'a']);

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (freq[ch - 'a'] > 0) {
                pq.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        char prev = '$';

        while (!pq.isEmpty()) {
            char curr = pq.remove();
            sb.append(curr);

            if (prev != '$') {
                pq.add(prev);
            }

            if (freq[curr - 'a'] > 1) {
                freq[curr - 'a']--;
                prev = curr;
            } else {
                prev = '$';
            }
        }

        if (prev != '$' && prev != sb.charAt(sb.length() - 1)) {
            sb.append(prev);
        }

        return sb.length() == s.length() ? sb.toString() : "";
    }
}
