class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>();

        for(String deadend : deadends){
            dead.add(deadend);
        }

        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        if(!dead.contains("0000")){
            queue.add("0000");
            visited.add("0000");
        }
        
        int count = 0;

        while(!queue.isEmpty()){
            int n = queue.size();

            while(n-->0){
                String curr = queue.remove();

                if(curr.equals(target)) return count;

                for(int i=0; i<4; i++){
                    StringBuilder sb = new StringBuilder();
                    sb.append(curr);
                    int ch = curr.charAt(i) - '0';
                    int next = (ch + 1) % 10;

                    sb.setCharAt(i,(char) (next+'0'));
                    String modifiedString = sb.toString();
                    if(dead.contains(modifiedString) || visited.contains(modifiedString)){
                        continue;
                    }

                    queue.add(modifiedString);
                    visited.add(modifiedString);
                    
                }

                for(int i=0; i<4; i++){
                    StringBuilder sb = new StringBuilder();
                    sb.append(curr);
                    int ch = curr.charAt(i) - '0';
                    int next = ((ch - 1) % 10  + 10) % 10;

                    sb.setCharAt(i,(char) (next+'0'));
                    // System.out.println((next));
                    String modifiedString = sb.toString();
                    if(dead.contains(modifiedString) || visited.contains(modifiedString)){
                        continue;
                    }

                    queue.add(modifiedString);
                    visited.add(modifiedString);
                    
                }
                 
            }
            count++;
        }
        return -1;
    }

}