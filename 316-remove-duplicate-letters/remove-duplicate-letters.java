public class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> lastOcc = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            lastOcc.put(s.charAt(i), i);
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seen.contains(c)) {
                while (!st.isEmpty() && c < st.peek() && i < lastOcc.get(st.peek())) {
                    seen.remove(st.pop());
                }
                seen.add(c);
                st.push(c);
            }
        }
        
        StringBuilder result = new StringBuilder();

        while(!st.isEmpty()){
            result.append(st.pop());
        }
        return result.reverse().toString();
    }
}