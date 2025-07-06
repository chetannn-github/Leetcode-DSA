class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> freq = new HashMap<>();
        
        for(char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch,0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)-> (freq.get(b) - freq.get(a)));

        for(char key : freq.keySet()) {
            pq.add(key);
        }

        StringBuilder sb = new StringBuilder();
        char prev = '$';

        while(!pq.isEmpty()) {
            char curr = pq.remove();
            sb.append(curr);

            if(prev != '$') pq.add(prev);

            if(freq.get(curr) > 1) {
                freq.put(curr,freq.get(curr) - 1);
                prev = curr;
            }
            else {
                freq.remove(curr);
                prev = '$';
            }
            
        }

        if(prev != sb.charAt(sb.length() - 1) && prev != '$') {
            sb.append(prev);
        }
       

        return sb.length() == s.length() ? sb.toString() : "";

    }
}