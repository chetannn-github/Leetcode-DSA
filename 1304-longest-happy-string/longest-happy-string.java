// class Solution {
//     public String longestDiverseString(int a, int b, int c) {
//         PriorityQueue<Pair> pq = new PriorityQueue<>((d,e)-> (e.freq - d.freq));

//         if(a>0) pq.add(new Pair(0,a));
//         if(b>0) pq.add(new Pair(1,b));
//         if(c>0) pq.add(new Pair(2,c));
        
//         Pair prev = null;

//         StringBuilder sb = new StringBuilder();
//         while(!pq.isEmpty()) {
//             char ch = (char) (pq.peek().ch + 'a');
//             int freq = pq.remove().freq;

//             if(freq >= 2 && (prev == null || prev.freq <= freq)) {
//                 sb.append(ch);
//                 sb.append(ch);
//                 freq -= 2;
                
//             }else {
//                 sb.append(ch);
//                 freq--;
//             }
//             if (prev != null) {
//                 pq.add(prev);
//                 prev = null;
//             }

//             if(!pq.isEmpty() && freq >=1) {
//                 prev = new Pair(ch - 'a', freq);
//             }

            
//         }

//         return sb.toString();
//     }
// }


// class Pair{
//     int ch, freq;
//     Pair(int ch, int freq) {
//         this.ch = ch;
//         this.freq = freq;
//     }
// }



class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.freq - x.freq);

        if (a > 0) pq.add(new Pair('a', a));
        if (b > 0) pq.add(new Pair('b', b));
        if (c > 0) pq.add(new Pair('c', c));

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair first = pq.remove();
            int len = sb.length();

            if (len >= 2 && sb.charAt(len - 1) == first.ch && sb.charAt(len - 2) == first.ch) {
                if (pq.isEmpty()) break;

                Pair second = pq.remove();
                sb.append(second.ch);
                second.freq--;

                if (second.freq > 0) pq.add(second);
                pq.add(first);
            } else {
                sb.append(first.ch);
                first.freq--;

                if (first.freq > 0) pq.add(first);
            }
        }

        return sb.toString();
    }
}

class Pair {
    char ch;
    int freq;

    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}
