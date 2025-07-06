class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((d,e)-> (e.freq - d.freq));

        if(a>0) pq.add(new Pair(0,a));
        if(b>0) pq.add(new Pair(1,b));
        if(c>0) pq.add(new Pair(2,c));
        
        Pair pending = null;

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            char ch = (char) (pq.peek().ch + 'a');
            int freq = pq.remove().freq;

            if(freq >= 2 && (pending == null || pending.freq <= freq)) {
                sb.append(ch);
                sb.append(ch);
                freq -= 2;
                
            }else {
                sb.append(ch);
                freq--;
            }
            if (pending != null) {
                pq.add(pending);
                pending = null;
            }

            if(!pq.isEmpty() && freq >=1) {
                pending = new Pair(ch - 'a', freq);
            }

            
        }

        return sb.toString();
    }
}


class Pair{
    int ch, freq;
    Pair(int ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}