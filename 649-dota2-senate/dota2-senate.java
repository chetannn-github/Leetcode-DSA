class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<>();
        int R = 0;
        int D = 0;
        for(char ch : senate.toCharArray()) {
            queue.add(ch);
            if(ch == 'R') R++;
            else D++;
        }
        int powerR = 0;
        int powerD = 0;
        int size = R + D;

        while (!queue.isEmpty()) {
            char ch = queue.remove();
            
            if (ch == 'R') {
                if (powerD == 0) {
                    queue.add(ch);
                    powerR++;
                }else {
                    powerD--;
                    R--;
                    size --;
                }
               
            }else {
                if (powerR == 0) {
                    queue.add(ch);
                    powerD++;
                }else {
                    powerR--;
                    D--;
                    size --;
                }
            }

            if(R == size) return new String("Radiant");
            else if(D == size) return new String("Dire");
        }

        return new String("Dire");
        
    }
}