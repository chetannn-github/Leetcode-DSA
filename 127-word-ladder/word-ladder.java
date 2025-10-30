class Solution {
    HashSet<String> visited,valid ;
    String start,end;
    int n;
    public int ladderLength(String start, String end, List<String> wordList) {
        visited = new HashSet<>();
        valid = new HashSet<>();
        this.start = start;
        this.end = end;
        n = start.length();

        for(String word : wordList) valid.add(word);

        if(!valid.contains(end)) return 0;
        return solve(0);
    }

    public int solve(int mutation){
        Queue<String> queue = new LinkedList<>();
        StringBuilder s;

        visited.add(start);
        queue.add(start);

        while(!queue.isEmpty()){
            int currSize = queue.size();

            while(currSize-->0){
                String curr = queue.remove();
                s = new StringBuilder(curr);

                if(curr.equals(end)) return mutation + 1;

                for(int i=0; i<n; i++){
                    char from = curr.charAt(i);

                    for(int j=0; j<26; j++) {
                        char to = (char) (j + 'a');
                        
                        if(from != to) {
                            s.setCharAt(i,to);
                            String mutated = s.toString();
                            if(!visited.contains(mutated) && valid.contains(mutated)){
                                queue.add(mutated);
                                visited.add(mutated);
                            }
                            s.setCharAt(i,from);
                        }
                    } 
                } 
            }
            
            mutation++;
        }

        return 0;
    }
}