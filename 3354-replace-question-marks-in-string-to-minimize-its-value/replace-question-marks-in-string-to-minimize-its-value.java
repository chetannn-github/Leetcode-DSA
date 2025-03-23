class Solution {
    public String minimizeStringValue(String s) {
        int[] freq = new int[26];
        int n = s.length();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return freq[a] == freq[b] ? a - b : freq[a] - freq[b];
        });

        for(int i=0; i<n; i++){
            char currChar = s.charAt(i);
            if(currChar != '?'){
                freq[(int)(currChar - 'a')]++;
            }  
        }

        for(int i=0; i<26;i++){
            pq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        List<Integer> replacement = new ArrayList<>();

        for(int i=0; i<n; i++){
            char currChar = s.charAt(i);

            if(currChar == '?'){
                int ch = pq.remove();
                replacement.add(ch);
                
                freq[ch]++;
                pq.add(ch);
            }
        }

        Collections.sort(replacement);

        int replacementIdx = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '?'){
                char replacedChar =(char) (replacement.get(replacementIdx) + 'a');
                sb.append(replacedChar);
                replacementIdx++;
            }else{
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();

        
    }
}